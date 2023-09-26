package org.wanbang.study.disruptorStudy.disruptorOwnerPackage.handler;

import com.lmax.disruptor.EventHandler;
import org.wanbang.study.disruptorStudy.disruptorOwnerPackage.event.MessageEventOwner;

/**
* @description: 消息事件处理类，这里只打印消息
* @author majiajian
* @date 2022/8/29 13:33
* @version 1.0
*/

public class MessageEventHandler implements EventHandler<MessageEventOwner> {

    @Override
    public void onEvent(MessageEventOwner messageEventOwner, long l, boolean b) throws Exception {
        System.out.println("消息事件处理类，这里只打印消息:" + messageEventOwner.getMessage() + "\n");
    }

}
