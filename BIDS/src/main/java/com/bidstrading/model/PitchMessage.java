package com.bidstrading.model;

/**
 * Parent class of all pitch messages
 *
 */
public class PitchMessage {
    final public int timeStamp;
    final public String messageType;

    public PitchMessage(int timeStamp, String messageType) {
        this.timeStamp = timeStamp;
        this.messageType = messageType;
    }

    @Override
    public String toString() {
        return "PitchMessage{" +
                "timeStamp=" + timeStamp +
                ", messageType='" + messageType + '\'' +
                '}';
    }
}
