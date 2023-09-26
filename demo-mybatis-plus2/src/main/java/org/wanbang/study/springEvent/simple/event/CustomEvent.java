package org.wanbang.study.springEvent.simple.event;

import org.springframework.context.ApplicationEvent;

/**
* @description: 事件类
* @author majiajian
* @date 2022/12/7 12:55
* @version 1.0
*/

public class CustomEvent extends ApplicationEvent {
    private String message;

    public CustomEvent(Object source,String message){
        super(source);
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
