package org.wanbang.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wanbang.redislock.CacheKey;
import org.wanbang.redislock.RedisLock;
import org.wanbang.redislock.response.SingleResponse;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.Set;
import java.util.TreeSet;

@Slf4j
@RestController("/redis")
public class TestRedisLock {
    @Resource
    private RedisLock redisLock;

    @GetMapping("/test1")
    public void test1() {
        redisLock.tryConcurrentLock(() ->getValue(), CacheKey.builder().key("KPI_RANK_GRADE_JOB").expire(Duration.ofMinutes(30)).build());
    }

    public SingleResponse<Integer> getValue(){
        return SingleResponse.ok();
    }


    /**
     * redission处理延时队列
     */
    @Autowired
    private StringRedisTemplate redisTemplate;

    // 生产者，将消息放入延时队列
    @GetMapping("/test2")
    public void produce() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            long currentTime = System.currentTimeMillis() / 1000L + 1;
            redisTemplate.opsForZSet().add("delay_queue", "测试", currentTime);
        }

        while (true){
            Thread.sleep(1000);
            long currentTime = System.currentTimeMillis() / 1000L;
            Set<String> values = redisTemplate.opsForZSet().rangeByScore("delay_queue", 0, currentTime);
            if (values != null && !values.isEmpty()) {
                for (String value : values) {
                    // 处理业务逻辑
                    System.out.println("处理消息: " + value);

                    // 处理完毕后移除队列中的消息
                    redisTemplate.opsForZSet().remove("delay_queue", value);
                }
            }
        }

    }
}
