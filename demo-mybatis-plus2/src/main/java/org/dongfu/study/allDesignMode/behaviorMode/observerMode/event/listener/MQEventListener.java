package org.dongfu.study.allDesignMode.behaviorMode.observerMode.event.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.dongfu.study.allDesignMode.behaviorMode.observerMode.entity.LotteryResult;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/19 15:24
* @version 1.0
*/

/**
 * MQ发送事件
 */
public class MQEventListener implements EventListener {
    private Logger logger = LoggerFactory.getLogger(MQEventListener.class);

    @Override
    public void doEvent(LotteryResult result) {
        logger.info("记录⽤户 {} 摇号结果(MQ)：{}", result.getUId(), result.getMsg());
    }

}
