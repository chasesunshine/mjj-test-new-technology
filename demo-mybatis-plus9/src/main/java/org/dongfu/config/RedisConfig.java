package org.dongfu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@Configuration
public class RedisConfig {
//    @Autowired
//    private RedisTemplate<String,String> redisTemplate;
//
//    @Bean
//    public void testRedis(){
//        ValueOperations<String, String> ops = redisTemplate.opsForValue();
//        ops.set("majiajian","ceshi1");
//    }
}
