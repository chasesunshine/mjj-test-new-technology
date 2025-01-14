package org.wanbang.design.eventmessagingmechanism;

import org.wanbang.design.eventmessagingmechanism.buttonclick.ButtonClickEvent;
import org.wanbang.design.eventmessagingmechanism.buttonclick.ButtonClickEventHandler;

public class Test {
    public static void main(String[] args) {
        // 创建一个事件分派器
        EventDispatcher eventDispatcher = new EventDispatcher();

        // 创建一个按钮单击事件
        ButtonClickEvent buttonClickEvent = new ButtonClickEvent();

        // 创建一个处理程序来处理按钮单击事件
        EventHandler buttonClickEventHandler = new ButtonClickEventHandler();

        // 将处理程序添加到事件分派器
        eventDispatcher.addHandler(buttonClickEventHandler);

        // 分派按钮单击事件
        eventDispatcher.dispatchEvent(buttonClickEvent);
    }
}

