package com.bidstrading.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * Factory that parses pitch message and create corresponding instance of java object
 *
 */
public class PitchMessageFactory {
    private static Logger LOG = LoggerFactory.getLogger(PitchMessageFactory.class);

    public static Optional<PitchMessage> fromPitchMessage(String msg) {
        if (msg == null || msg.trim().isEmpty()) {
            throw new IllegalArgumentException("Message is either null or empty");
        }
        int offset = 0;
        if (msg.charAt(0) == 'S') {
            offset = 1;
        }
        try {
            int timeStamp = Integer.parseInt(msg.substring(offset, offset + 8));
            offset += 8;
            String msgType = msg.substring(offset, offset + 1);
            offset += 1;
            switch (msgType) {
                case "A":
                    return Optional.of(buildAddOrder(msg, timeStamp, offset));
                case "E":
                    return Optional.of(buildOrderExecuted(msg, timeStamp, offset));
                case "X":
                    return Optional.of(buildOrderCancel(msg, timeStamp, offset));
                case "P":
                    return Optional.of(buildTrade(msg, timeStamp, offset));
                case "H":
                    return Optional.of(buildTradingStatus(msg, timeStamp, offset));
                default:
                    LOG.error("Message type " + msgType + " is not supported yet");
                    return Optional.empty();
            }

        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            LOG.error("Could not parse this message " + msg, e);
            return Optional.empty();
        }

    }

    private static AddOrder buildAddOrder(String msg, int timeStamp, int offset) {
        String orderId = msg.substring(offset, offset + 12);
        offset += 12;
        String side = msg.substring(offset, offset + 1);
        offset += 1;
        int shares = Integer.parseInt(msg.substring(offset, offset + 6));
        offset += 6;
        String stockSymbol = msg.substring(offset, offset + 6);
        offset += 6;
        int wholePrice = Integer.parseInt(msg.substring(offset, offset + 6));
        offset += 6;
        int fractionPrice = Integer.parseInt(msg.substring(offset, offset + 4));
        offset += 4;
        String display = msg.substring(offset, offset + 1);

        double price = Double.parseDouble(wholePrice + "." + fractionPrice);
        return new AddOrder(timeStamp, "A", orderId, side, shares, stockSymbol, price, display);
    }

    private static OrderExecuted buildOrderExecuted(String msg, int timeStamp, int offset) {
        String orderId = msg.substring(offset, offset + 12);
        offset += 12;
        int shares = Integer.parseInt(msg.substring(offset, offset + 6));
        offset += 6;
        String executionId = msg.substring(offset, offset + 12);

        return new OrderExecuted(timeStamp, "E", orderId, shares, executionId);
    }

    private static OrderCancel buildOrderCancel(String msg, int timeStamp, int offset) {
        String orderId = msg.substring(offset, offset + 12);
        offset += 12;
        int shares = Integer.parseInt(msg.substring(offset, offset + 6));

        return new OrderCancel(timeStamp, "X", orderId, shares);
    }

    private static Trade buildTrade(String msg, int timeStamp, int offset) {
        String orderId = msg.substring(offset, offset + 12);
        offset += 12;
        String side = msg.substring(offset, offset + 1);
        offset += 1;
        int shares = Integer.parseInt(msg.substring(offset, offset + 6));
        offset += 6;
        String stockSymbol = msg.substring(offset, offset + 6);
        offset += 6;
        int wholePrice = Integer.parseInt(msg.substring(offset, offset + 6));
        offset += 6;
        int fractionPrice = Integer.parseInt(msg.substring(offset, offset + 4));
        offset += 4;
        String executionId = msg.substring(offset, offset + 12);

        double price = Double.parseDouble(wholePrice + "." + fractionPrice);
        return new Trade(timeStamp, "P", orderId, side, shares, stockSymbol, price, executionId);
    }

    private static TradingStatus buildTradingStatus(String msg, int timeStamp, int offset) {
        String stockSymbol = msg.substring(offset, offset + 6);
        offset += 6;
        String haltStatus = msg.substring(offset, offset + 1);
        offset += 1;
        int regAction = Integer.parseInt(msg.substring(offset, offset + 1));

        return new TradingStatus(timeStamp, "P", stockSymbol, haltStatus, regAction);
    }
}
