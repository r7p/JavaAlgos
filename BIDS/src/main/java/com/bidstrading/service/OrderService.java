package com.bidstrading.service;

import com.bidstrading.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Processes orders and trades, builds Blotter as messages are processed
 * This service is not a thread safe as I assumed SOUP 2.0 protocol sends messages sequentially.  These messages need
 * to be processed in correct sequence in order to build order book or Blotter.
 *
 */
public class OrderService {
    private final static Logger LOG = LoggerFactory.getLogger(OrderService.class);

    final Map<String, Blotter> orderBlotter = new HashMap<>();
    final Map<String, Integer> executionVolume = new HashMap<>();

    public void addOrder(AddOrder theOrder) {
        Blotter blotter = Blotter.from(theOrder);
        orderBlotter.put(blotter.orderId, blotter);
    }
    public void processOrderCancel(OrderCancel theOrder) {
        orderBlotter.computeIfPresent(theOrder.orderId, (orderId, blotter) ->
            blotter.processOrderCancel(theOrder)
        );
    }
    public void processOrderExecuted(OrderExecuted theOrder) {
        Blotter blotter = orderBlotter.computeIfPresent(theOrder.orderId, (orderId, bl) ->
                bl.processOrderExecuted(theOrder)
        );
        if (blotter == null) {
            LOG.error("Execution message received for which no order exists " + theOrder);
        } else {
            executionVolume.put(blotter.stockSymbol, executionVolume.getOrDefault(blotter.stockSymbol, 0) + blotter.shares);
        }
    }
    public void processTrade(Trade trade) {
        String orderId = trade.orderId;
        if (orderBlotter.containsKey(orderId)) {
            orderBlotter.get(orderId).processTradeWithOrderId(trade);
        } else {
            orderBlotter.put(orderId, Blotter.from(trade));
        }
        Blotter blotter = orderBlotter.get(orderId);
        executionVolume.put(blotter.stockSymbol, executionVolume.getOrDefault(blotter.stockSymbol, 0) + blotter.shares);
    }

    public Map<String, Integer> executionVolume() {
        return Collections.unmodifiableMap(executionVolume);
    }
}
