package org.dongfu.study.disruptorStudy.disruptorOwnerPackage.translate;
/**
* @description: 消息转换类，负责将消息转换为事件
* @author majiajian
* @date 2022/8/29 14:52
* @version 1.0
*/

import com.lmax.disruptor.EventTranslatorOneArg;
import lombok.extern.slf4j.Slf4j;
import org.dongfu.study.disruptorStudy.disruptorOwnerPackage.event.MessageEventOwner;

@Slf4j
public class MessageEventTranslator implements EventTranslatorOneArg<MessageEventOwner,String> {
    @Override
    public void translateTo(MessageEventOwner messageEventOwner, long l, String s) {
        log.info("消息转换类，负责将消息转换为事件");
        messageEventOwner.setMessage(s);
    }
}
