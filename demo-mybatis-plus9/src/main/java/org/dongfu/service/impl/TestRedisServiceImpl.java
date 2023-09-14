package org.dongfu.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.dongfu.service.TestRedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (SpringWord)表服务实现类
 *
 * @author makejava
 * @since 2022-06-16 10:17:43
 */
@Slf4j
@Service
public class TestRedisServiceImpl implements TestRedisService {
    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public void testRedisInsert(String key, String value) {
        log.info("参数 {} {}",key,value);

//        ops.set("majiajian","ceshi1");
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ops.set(key,value);

    }
}
