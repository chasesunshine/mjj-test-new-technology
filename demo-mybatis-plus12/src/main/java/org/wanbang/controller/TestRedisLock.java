package org.wanbang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wanbang.redislock.CacheKey;
import org.wanbang.redislock.RedisLock;
import org.wanbang.redislock.response.SingleResponse;

import javax.annotation.Resource;
import java.time.Duration;

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
}
