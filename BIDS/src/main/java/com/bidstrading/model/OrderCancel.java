package com.bidstrading.model;

public class OrderCancel extends PitchMessage {
    final public String orderId;
    final public int shares;

    public OrderCancel(int timeStamp, String messageType, String orderId, int shares) {
        super(timeStamp, messageType);
        this.orderId = orderId;
        this.shares = shares;
    }

    @Override
    public String toString() {
        return "OrderCancel{" +
                "orderId='" + orderId + '\'' +
                ", shares=" + shares +
                ", timeStamp=" + timeStamp +
                ", messageType='" + messageType + '\'' +
                '}';
    }
}
