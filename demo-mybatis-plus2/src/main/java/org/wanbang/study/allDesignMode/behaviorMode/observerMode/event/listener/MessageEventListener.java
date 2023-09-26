package org.wanbang.study.allDesignMode.behaviorMode.observerMode.event.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wanbang.study.allDesignMode.behaviorMode.observerMode.entity.LotteryResult;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/19 15:23
* @version 1.0
*/

/**
 * 短消息事件
 */
public class MessageEventListener implements EventListener {
    private Logger logger = LoggerFactory.getLogger(MessageEventListener.class);

    @Override
    public void doEvent(LotteryResult result) {
        logger.info("给⽤户 {} 发送短信通知(短信)：{}", result.getUId(), result.getMsg());
    }
}
