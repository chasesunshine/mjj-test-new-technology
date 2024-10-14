package org.wanbang.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisCallback;
import org.wanbang.service.TestRedisService;
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

    public void executeTransaction() {
        redisTemplate.execute((RedisCallback<Object>) connection -> {
            connection.multi();
            connection.set("key1".getBytes(), "value1".getBytes());
            connection.set("key2".getBytes(), "value2".getBytes());
            connection.incr("counter".getBytes());
            connection.exec();
            return null;
        });
    }

    public void rollbackTransaction() {
        redisTemplate.execute((RedisCallback<Object>) connection -> {
            connection.multi();
            connection.set("key1".getBytes(), "value1".getBytes());
            connection.set("key2".getBytes(), "value2".getBytes());
            connection.incr("counter".getBytes());
            // 这地方直接放弃设置
            connection.discard();
            return null;
        });
    }

}
