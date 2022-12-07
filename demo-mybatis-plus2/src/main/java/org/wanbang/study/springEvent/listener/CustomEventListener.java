package org.wanbang.study.springEvent.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.wanbang.study.springEvent.event.CustomEvent;

/**
* @description: 事件监听类
* @author majiajian
* @date 2022/12/7 12:55
* @version 1.0
*/

@Component
public class CustomEventListener {

    @EventListener(CustomEvent.class)
    public void onApplicationEvent(CustomEvent customEvent){
        System.out.println("监听器接受消息："+System.currentTimeMillis());
        System.out.println("接收到的消息为："+customEvent.getMessage());
    }

}
