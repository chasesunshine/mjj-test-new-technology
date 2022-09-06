package org.wanbang.study.disruptorStudy.disruptorOwnerPackage.factory;
/**
* @description: 消息事件工厂类
* @author majiajian
* @date 2022/8/29 13:39
* @version 1.0
*/
import com.lmax.disruptor.EventFactory;
import lombok.extern.slf4j.Slf4j;
import org.wanbang.study.disruptorStudy.disruptorOwnerPackage.event.MessageEventOwner;

@Slf4j
public class MessageEventFactory implements EventFactory<MessageEventOwner> {

    /**
     * 消息事件工厂类
     * @return
     */
    @Override
    public MessageEventOwner newInstance() {
        return new MessageEventOwner();
    }

}
