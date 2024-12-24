package org.wanbang.delayqueue.handler;

/**
 * 描述: 延迟队列执行器 <br>
 * 时间: 2022/8/05 14:16
 */
public interface RedisDelayQueueHandle<T> {
    void execute(T t);
}
