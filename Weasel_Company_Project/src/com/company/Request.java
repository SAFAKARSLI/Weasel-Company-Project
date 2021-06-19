package com.company;

public class Request {

    String ID;
    Staff from;
    Manager to;
    String type;
    String reason;
    String extraMessages;

    public Request(String ID, Staff from, Manager to, String type, String reason, String extraMessages) {
        this.ID = ID;
        this.from = from;
        this.to = to;
        this.type = type;
        this.reason = reason;
        this.extraMessages = extraMessages;
    }
}
