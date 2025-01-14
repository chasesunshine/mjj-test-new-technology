package org.wanbang.design.eventmessagingmechanism.buttonclick;

import org.wanbang.design.eventmessagingmechanism.Event;
import org.wanbang.design.eventmessagingmechanism.EventHandler;

public class ButtonClickEventHandler implements EventHandler {
    public void handleEvent(Event event) {
        if (event.getType().equals("ButtonClickEvent")) {
            // 执行单击按钮时要执行的操作
            System.out.println("Button clicked");
        }
    }
}
