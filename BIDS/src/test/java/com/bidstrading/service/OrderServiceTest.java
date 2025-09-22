package com.bidstrading.service;

import com.bidstrading.model.*;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {
    private final OrderService orderService = new OrderService();

    @Test
    void testOrderCycle() {
        String msg = "S28800012ABK27GA00000LB001000SSO   0000763600Y";
        Optional<PitchMessage> pitchMessage = PitchMessageFactory.fromPitchMessage(msg);
        AddOrder theOrder = (AddOrder) pitchMessage.get();
        String orderId = theOrder.orderId;
        String executionId = "testExecutionId";

        orderService.addOrder(theOrder);

        assertEquals(1, orderService.orderBlotter.size());
        Blotter blotter = orderService.orderBlotter.get(orderId);
        assertEquals(28800012, blotter.timeStamp);
        assertEquals("BK27GA00000L", orderId);
        assertEquals("B", blotter.side);
        assertEquals(1000, blotter.shares);
        assertEquals("SSO   ", blotter.stockSymbol);
        assertEquals(76.36d, blotter.price);

        // adjust order quantity
        OrderCancel orderCancel = new OrderCancel(28800412, "X", orderId, 750);
        orderService.processOrderCancel(orderCancel);
        assertTrue(orderService.orderBlotter.containsKey(orderId));
        blotter = orderService.orderBlotter.get(orderId);
        assertEquals(750, blotter.shares);
        assertTrue(orderService.executionVolume.isEmpty());

        // execute the order
        OrderExecuted orderExecuted = new OrderExecuted(28800712, "E", orderId, 700, executionId);
        orderService.processOrderExecuted(orderExecuted);
        blotter = orderService.orderBlotter.get(orderId);
        assertEquals(700, blotter.shares);
        assertEquals(executionId, blotter.executionId);
        assertEquals(700, orderService.executionVolume.get(blotter.stockSymbol));
    }

    @Test
    void testTradeCycle() {
        String msg = "S28824813AAK27GA0000E7B001000SPY   0001425300Y";
        Optional<PitchMessage> pitchMessage = PitchMessageFactory.fromPitchMessage(msg);
        AddOrder theOrder = (AddOrder) pitchMessage.get();
        String orderId = theOrder.orderId;
        String executionId = "testExecutionId";
        int shares = theOrder.shares;

        orderService.addOrder(theOrder);

        assertEquals(1, orderService.orderBlotter.size());

        // create un-hidden trade
        Trade visibleTrade = new Trade(28825813, "P", orderId, theOrder.side, shares, theOrder.stockSymbol, theOrder.price, executionId);

        // execute
        orderService.processTrade(visibleTrade);

        // assert
        assertEquals(1, orderService.orderBlotter.size());
        Blotter blotter = orderService.orderBlotter.get(orderId);
        assertNotNull(blotter);
        assertEquals(orderId, blotter.orderId);
        assertEquals(shares, blotter.shares);
        assertEquals(shares, orderService.executionVolume.get(blotter.stockSymbol));

        // create hidden trade
        String hiddenOrderId = "hiddenTradeOrderId";
        int hiddenTradeShares = 330;
        String hiddenExecId = "hiddenExecutionId";
        Trade hiddenTrade = new Trade(28865813, "P", hiddenOrderId, "S", hiddenTradeShares, theOrder.stockSymbol, theOrder.price, hiddenExecId);

        // execute
        orderService.processTrade(hiddenTrade);

        // assert
        assertEquals(2, orderService.orderBlotter.size());
        blotter = orderService.orderBlotter.get(hiddenOrderId);
        assertNotNull(blotter);
        assertEquals(hiddenOrderId, blotter.orderId);
        assertEquals(hiddenTradeShares, blotter.shares);
        // total executed qty for this stock symbol will be aggregate of 2 trades
        assertEquals(shares + hiddenTradeShares, orderService.executionVolume.get(blotter.stockSymbol));
    }

}
