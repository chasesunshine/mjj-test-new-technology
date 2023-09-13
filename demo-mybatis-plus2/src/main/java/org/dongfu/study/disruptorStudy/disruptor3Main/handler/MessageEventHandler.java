package org.dongfu.study.disruptorStudy.disruptor3Main.handler;
/**
* @description: TODO
* @author majiajian
* @date 2022/8/29 13:33
* @version 1.0
*/

import com.lmax.disruptor.EventHandler;
import org.dongfu.study.disruptorStudy.disruptor3Main.event.MessageEvent;

/**
 * 消息事件处理类，这里只打印消息
 */
public class MessageEventHandler implements EventHandler<MessageEvent> {

    @Override
    public void onEvent(MessageEvent messageEvent, long l, boolean b) throws Exception {
        System.out.println("消息事件处理类，这里只打印消息:" + messageEvent.getMessage() + "\n");
    }

}
