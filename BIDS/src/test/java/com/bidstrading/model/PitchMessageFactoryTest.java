package com.bidstrading.model;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class PitchMessageFactoryTest {

    @Test
    void testAddOrder_Success() {
        String msg = "S28800012ABK27GA00000LB001000SSO   0000763600Y";
        Optional<PitchMessage> pitchMessage = PitchMessageFactory.fromPitchMessage(msg);
        assertTrue(pitchMessage.isPresent());
        assertEquals(pitchMessage.get().getClass(), AddOrder.class);

        AddOrder theOrder = (AddOrder) pitchMessage.get();
        assertEquals(28800012, theOrder.timeStamp);
        assertEquals("BK27GA00000L", theOrder.orderId);
        assertEquals("B", theOrder.side);
        assertEquals(1000, theOrder.shares);
        assertEquals("SSO   ", theOrder.stockSymbol);
        assertEquals(76.36d, theOrder.price);
        assertEquals("Y", theOrder.display);
    }

    @Test
    void testOrderExecuted_Success() {
        String msg = "S28800318E1K27GA00000X00010000001AQ00001";
        Optional<PitchMessage> pitchMessage = PitchMessageFactory.fromPitchMessage(msg);
        assertTrue(pitchMessage.isPresent());
        assertEquals(pitchMessage.get().getClass(), OrderExecuted.class);

        OrderExecuted orderExecuted = (OrderExecuted) pitchMessage.get();
        assertEquals(28800318, orderExecuted.timeStamp);
        assertEquals("1K27GA00000X", orderExecuted.orderId);
        assertEquals(100, orderExecuted.shares);
        assertEquals("00001AQ00001", orderExecuted.executionId);
    }

    @Test
    void testOrderCancel_Success() {
        String msg = "S28811549XBK27GA000018002000";
        Optional<PitchMessage> pitchMessage = PitchMessageFactory.fromPitchMessage(msg);
        assertTrue(pitchMessage.isPresent());
        assertEquals(pitchMessage.get().getClass(), OrderCancel.class);

        OrderCancel orderCancel = (OrderCancel) pitchMessage.get();
        assertEquals(28811549, orderCancel.timeStamp);
        assertEquals("BK27GA000018", orderCancel.orderId);
        assertEquals(2000, orderCancel.shares);
    }

    @Test
    void testTrade_Success() {
        String msg = "S28816741P1K27GA000011B000100AAPL  0001830100000N1AQ00002";
        Optional<PitchMessage> pitchMessage = PitchMessageFactory.fromPitchMessage(msg);
        assertTrue(pitchMessage.isPresent());
        assertEquals(pitchMessage.get().getClass(), Trade.class);

        Trade trade = (Trade) pitchMessage.get();
        assertEquals(28816741, trade.timeStamp);
        assertEquals("1K27GA000011", trade.orderId);
        assertEquals("B", trade.side);
        assertEquals(100, trade.shares);
        assertEquals("AAPL  ", trade.stockSymbol);
        assertEquals(183.1d, trade.price);
        assertEquals("000N1AQ00002", trade.executionId);
    }

    @Test
    void testTradingStatus_Success() {
        String msg = "S28816741HAAPL  A0XX";
        Optional<PitchMessage> pitchMessage = PitchMessageFactory.fromPitchMessage(msg);
        assertTrue(pitchMessage.isPresent());
        assertEquals(pitchMessage.get().getClass(), TradingStatus.class);

        TradingStatus tradingStatus = (TradingStatus) pitchMessage.get();
        assertEquals(28816741, tradingStatus.timeStamp);
        assertEquals("AAPL  ", tradingStatus.stockSymbol);
        assertEquals("A", tradingStatus.haltStatus);
        assertEquals(0, tradingStatus.regAction);
    }
}
