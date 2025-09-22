package com.bidstrading.model;

public class OrderExecuted extends PitchMessage {
    final public String orderId;
    final public int shares;
    final public String executionId;

    public OrderExecuted(int timeStamp, String messageType, String orderId, int shares, String executionId) {
        super(timeStamp, messageType);
        this.orderId = orderId;
        this.shares = shares;
        this.executionId = executionId;
    }

    @Override
    public String toString() {
        return "OrderExecuted{" +
                "orderId='" + orderId + '\'' +
                ", shares=" + shares +
                ", executionId='" + executionId + '\'' +
                ", timeStamp=" + timeStamp +
                ", messageType='" + messageType + '\'' +
                '}';
    }
}
