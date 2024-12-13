package org.wanbang.design.eventmessagingmechanism;

public class Event {
    private String type;

    public Event(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}