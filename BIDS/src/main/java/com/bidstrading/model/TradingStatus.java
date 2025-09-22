package com.bidstrading.model;

public class TradingStatus extends PitchMessage {
    final public String stockSymbol;
    final public String haltStatus;
    final public int regAction;

    public TradingStatus(int timeStamp, String messageType, String stockSymbol, String haltStatus, int regAction) {
        super(timeStamp, messageType);
        this.stockSymbol = stockSymbol;
        this.haltStatus = haltStatus;
        this.regAction = regAction;
    }

    @Override
    public String toString() {
        return "TradingStatus{" +
                "stockSymbol='" + stockSymbol + '\'' +
                ", haltStatus='" + haltStatus + '\'' +
                ", regAction=" + regAction +
                ", timeStamp=" + timeStamp +
                ", messageType='" + messageType + '\'' +
                '}';
    }
}
