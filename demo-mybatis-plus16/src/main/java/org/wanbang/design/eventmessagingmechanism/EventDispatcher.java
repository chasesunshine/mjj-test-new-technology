package org.wanbang.design.eventmessagingmechanism;

import java.util.ArrayList;
import java.util.List;

public class EventDispatcher {
    private List<EventHandler> handlers;

    public EventDispatcher() {
        handlers = new ArrayList<EventHandler>();
    }

    public void addHandler(EventHandler handler) {
        handlers.add(handler);
    }

    public void dispatchEvent(Event event) {
        for (EventHandler handler : handlers) {
            if (handler != null) {
                handler.handleEvent(event);
            }
        }
    }
}