package org.wanbang.delayqueue.handler.impl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.wanbang.delayqueue.handler.RedisDelayQueueHandle;
import org.wanbang.entity.Comment;

/**
 * 描述: 订单超时未评价处理类 <br>
 */
@Component
@Slf4j
public class OrderNotEvaluatedTimeout implements RedisDelayQueueHandle<Comment> {
    @Override
    public void execute(Comment comment) {
        log.info("(收到订单超时未评价延迟消息) {}", comment);
        // TODO 订单超时未评价，系统默认好评处理业务...
    }
}
