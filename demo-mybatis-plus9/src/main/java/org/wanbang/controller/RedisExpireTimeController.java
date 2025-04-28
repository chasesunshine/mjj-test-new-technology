package org.wanbang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

@RestController
public class RedisExpireTimeController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 测试redis过期时间
     */
    @GetMapping("/redis/expire")
    public void redisExpire() {
        redisTemplate.opsForValue().set("text","123",20, TimeUnit.SECONDS);
    }

}