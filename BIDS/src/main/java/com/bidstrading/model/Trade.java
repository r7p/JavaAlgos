package com.bidstrading.model;

public class Trade extends PitchMessage {
    final public String orderId; // obfuscated for hidden order OR orderId of OrderExecuted
    final public String side;
    final public int shares;
    final public String stockSymbol;
    final public double price;
    final public String executionId;

    public Trade(int timeStamp, String messageType, String orderId, String side, int shares, String stockSymbol,
                 double price, String executionId) {
        super(timeStamp, messageType);
        this.orderId = orderId;
        this.side = side;
        this.shares = shares;
        this.stockSymbol = stockSymbol;
        this.price = price;
        this.executionId = executionId;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "orderId='" + orderId + '\'' +
                ", side='" + side + '\'' +
                ", shares=" + shares +
                ", stockSymbol='" + stockSymbol + '\'' +
                ", price=" + price +
                ", executionId='" + executionId + '\'' +
                ", timeStamp=" + timeStamp +
                ", messageType='" + messageType + '\'' +
                '}';
    }
}
