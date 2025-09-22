package com.bidstrading.model;


public class AddOrder extends PitchMessage {
    final public String orderId;
    final public String side;
    final public int shares;
    final public String stockSymbol;
    final public double price;
    final public String display;

    public AddOrder(int timeStamp, String messageType, String orderId, String side, int shares, String stockSymbol,
                    double price, String display) {
        super(timeStamp, messageType);
        this.orderId = orderId;
        this.side = side;
        this.shares = shares;
        this.stockSymbol = stockSymbol;
        this.price = price;
        this.display = display;
    }

    @Override
    public String toString() {
        return "AddOrder{" +
                "orderId='" + orderId + '\'' +
                ", side='" + side + '\'' +
                ", shares=" + shares +
                ", stockSymbol='" + stockSymbol + '\'' +
                ", price=" + price +
                ", display='" + display + '\'' +
                ", timeStamp=" + timeStamp +
                ", messageType='" + messageType + '\'' +
                '}';
    }
}
