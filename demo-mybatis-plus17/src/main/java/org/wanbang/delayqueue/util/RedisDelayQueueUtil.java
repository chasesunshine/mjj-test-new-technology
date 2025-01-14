package org.wanbang.delayqueue.util;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBlockingDeque;
import org.redisson.api.RDelayedQueue;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
/**
 * 描述: 分布式延时队列工具类 <br>
 * 时间: 2022/8/05 14:16
 */
@Slf4j
@Component
public class RedisDelayQueueUtil {
    @Autowired
    private RedissonClient redissonClient;
    /**
     * 添加延迟队列
     *
     * @param value     队列值
     * @param delay     延迟时间
     * @param timeUnit  时间单位
     * @param queueCode 队列键
     * @param <T>
     */
    public <T> boolean addDelayQueue(@NonNull T value, @NonNull long delay, @NonNull TimeUnit timeUnit, @NonNull String queueCode) {
        if (StringUtils.isBlank(queueCode) || Objects.isNull(value)) {
            return false;
        }
        try {
            RBlockingDeque<Object> blockingDeque = redissonClient.getBlockingDeque(queueCode);
            RDelayedQueue<Object> delayedQueue = redissonClient.getDelayedQueue(blockingDeque);
            delayedQueue.offer(value, delay, timeUnit);
            //delayedQueue.destroy();
            log.info("(添加延时队列成功) 队列键：{}，队列值：{}，延迟时间：{}", queueCode, value, timeUnit.toSeconds(delay) + "秒");
        } catch (Exception e) {
            log.error("(添加延时队列失败) {}", e.getMessage());
            throw new RuntimeException("(添加延时队列失败)");
        }
        return true;
    }
    /**
     * 获取延迟队列
     *
     * @param queueCode
     * @param <T>
     */
    public <T> T getDelayQueue(@NonNull String queueCode) {
        if (StringUtils.isBlank(queueCode)) {
            return null;
        }
        RBlockingDeque<Objects> blockingDeque = redissonClient.getBlockingDeque(queueCode);
        T value = (T) blockingDeque.poll();
        return value;
    }
//    /**
//     * 删除指定队列中的消息
//     *
//     * @param o 指定删除的消息对象队列值(同队列需保证唯一性)
//     * @param queueCode 指定队列键
//     */
//    public boolean removeDelayedQueue(@NonNull Object o, @NonNull String queueCode) {
//        if (StringUtils.isBlank(queueCode) || Objects.isNull(o)) {
//            return false;
//        }
//        RBlockingDeque<Object> blockingDeque = redissonClient.getBlockingDeque(queueCode); RDelayedQueue<Object> delayedQueue =
//                redissonClient.getDelayedQueue(blockingDeque); boolean flag = delayedQueue.remove(o);
//        //delayedQueue.destroy();
//        return flag;
//    }
}
