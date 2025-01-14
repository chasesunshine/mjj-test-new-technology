package org.wanbang.delayqueue.handler.impl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.wanbang.delayqueue.handler.RedisDelayQueueHandle;
import org.wanbang.entity.UserInfo;

/**
 * 描述: 订单支付超时处理类 <br>
 * 时间: 2022/8/05 14:16
 */
@Component
@Slf4j
public class OrderPaymentTimeout implements RedisDelayQueueHandle<UserInfo> {
    @Override
    public void execute(UserInfo userInfo) {
        log.info("(倒计时处理完成) {}", userInfo);
        // TODO 订单支付超时，自动取消订单处理业务...
    }
}
