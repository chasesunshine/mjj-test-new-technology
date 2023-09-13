package org.dongfu.study.disruptorStudy.disruptor3Main.factory;
/**
* @description: TODO
* @author majiajian
* @date 2022/8/29 13:39
* @version 1.0
*/

import com.lmax.disruptor.EventFactory;
import lombok.extern.slf4j.Slf4j;
import org.dongfu.study.disruptorStudy.disruptor3Main.event.MessageEvent;

/**消息事件工厂类
 *
 */
@Slf4j
public class MessageEventFactory implements EventFactory<MessageEvent> {

    @Override
    public MessageEvent newInstance() {
        log.info("消息事件工厂类 \n");
        return new MessageEvent();
    }

}
