package com.bidstrading.model;


public class Blotter {
    public int timeStamp;
    public String messageType;
    final public String orderId; // obfuscated OR orderId of OrderExecuted
    final public String side;
    public int shares;
    final public String stockSymbol;
    final public double price;
    public String executionId;

    private Blotter(int timeStamp, String messageType, String orderId, String side, int shares, String stockSymbol,
                    double price) {
        this(timeStamp, messageType, orderId, side, shares, stockSymbol, price, null);
    }

    private Blotter(int timeStamp, String messageType, String orderId, String side, int shares, String stockSymbol,
                    double price, String executionId) {
        this.timeStamp = timeStamp;
        this.messageType = messageType;
        this.orderId = orderId;
        this.side = side;
        this.shares = shares;
        this.stockSymbol = stockSymbol;
        this.price = price;
        this.executionId = executionId;
    }

    /**
     * Create a blotter entry from new order
     *
     * @param theOrder  Order from which to create the entry from
     * @return  Newly created Blotter entry
     */
    public static Blotter from(AddOrder theOrder) {
        return new Blotter(theOrder.timeStamp, theOrder.messageType, theOrder.orderId, theOrder.side, theOrder.shares,
                           theOrder.stockSymbol, theOrder.price);
    }

    /**
     * Create a blotter entry from invisible or hidden order, using trade
     *
     * @param trade  Trade from which to create the entry from
     * @return  Newly created Blotter entry
     */
    public static Blotter from(Trade trade) {
        return new Blotter(trade.timeStamp, trade.messageType, trade.orderId, trade.side, trade.shares,
                           trade.stockSymbol, trade.price, trade.executionId);
    }

    public Blotter processOrderCancel(OrderCancel theOrder) {
        this.messageType = theOrder.messageType;
        this.shares = theOrder.shares;
        return this;
    }

    public Blotter processOrderExecuted(OrderExecuted theOrder) {
        this.messageType = theOrder.messageType;
        this.shares = theOrder.shares;
        this.executionId = theOrder.executionId;
        return this;
    }

    public Blotter processTradeWithOrderId(Trade trade) {
        this.messageType = trade.messageType;
        this.shares = trade.shares;
        this.executionId = trade.executionId;
        return this;
    }

    @Override
    public String toString() {
        return "Blotter{" +
                "timeStamp=" + timeStamp +
                ", messageType='" + messageType + '\'' +
                ", orderId='" + orderId + '\'' +
                ", side='" + side + '\'' +
                ", shares=" + shares +
                ", stockSymbol='" + stockSymbol + '\'' +
                ", price=" + price +
                ", executionId='" + executionId + '\'' +
                '}';
    }
}
