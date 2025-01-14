package org.wanbang.delayqueue.starter;
import jodd.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.wanbang.delayqueue.constant.RedisDelayQueueEnum;
import org.wanbang.delayqueue.handler.RedisDelayQueueHandle;
import org.wanbang.delayqueue.util.RedisDelayQueueUtil;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * 描述: 启动延迟队列监测扫描 <br>
 * 时间: 2022/8/05 16:16
 */
@Slf4j
@Component
public class RedisDelayQueueStarter{
    @Autowired
    private RedisDelayQueueUtil redisDelayQueueUtil;

    @Autowired
    private ApplicationContext context;

    @Resource
    private ThreadPoolTaskExecutor taskExecutor;

    /**
     * 0.5s监听
     */
    private final long period = 500L;

    /**
     * 线程池，维护keyAliveTime
     */
    private static final ScheduledExecutorService SCHEDULER = new ScheduledThreadPoolExecutor(1, new ThreadFactoryBuilder().setNameFormat("queue-delay-%d").setDaemon(true).get());

    @PostConstruct
    public void run(){
        // 每秒执行一次「续时」操作
        SCHEDULER.scheduleAtFixedRate(() -> {
            RedisDelayQueueEnum[] queueEnums = RedisDelayQueueEnum.values();
//            log.info("实时监听");
            for (RedisDelayQueueEnum queueEnum : queueEnums) {
                Object value = redisDelayQueueUtil.getDelayQueue(queueEnum.getCode());
                if (value != null) {
                    RedisDelayQueueHandle<Object> redisDelayQueueHandle = (RedisDelayQueueHandle<Object>)context.getBean(queueEnum.getBeanId());
                    taskExecutor.execute(() -> redisDelayQueueHandle.execute(value));
                    //redisDelayQueueHandle.execute(value);
                }
            }
        }, 0, period, TimeUnit.MILLISECONDS);
        log.info("====================Redission延迟队列监测启动成功====================");
    }
}
