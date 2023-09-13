package org.dongfu.study.springEvent.simple.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.dongfu.study.springEvent.simple.event.CustomEvent;

/**
* @description: 事件监听类
* @author majiajian
* @date 2022/12/7 12:55
* @version 1.0
*/

@Component
public class CustomEventListener {

    @EventListener(CustomEvent.class)
    public void onApplicationEvent1(CustomEvent customEvent){
        System.out.println("监听器接受消息1："+System.currentTimeMillis());
        System.out.println("接收到的消息1为："+customEvent.getMessage());
    }

    @EventListener(CustomEvent.class)
    public void onApplicationEvent2(CustomEvent customEvent){
        System.out.println("监听器接受消息2："+System.currentTimeMillis());
        System.out.println("接收到的消息2为："+customEvent.getMessage());
    }

}
