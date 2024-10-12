package org.wanbang.lru;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class LruCacheManager {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private static final String CACHE_KEY = "LRU_CACHE";
    private static final int MAX_CACHE_SIZE = 100;

    public void put(String key, String value) {
        long currentTime = System.currentTimeMillis();
        redisTemplate.opsForValue().set(key, value, 1, TimeUnit.DAYS); // 设置过期时间为1天
        redisTemplate.opsForZSet().add(CACHE_KEY, key, currentTime);
//        cleanup();
    }

    public String get(String key) {
        if (redisTemplate.hasKey(key)) {
            long currentTime = System.currentTimeMillis();
            redisTemplate.opsForZSet().incrementScore(CACHE_KEY, key, currentTime - redisTemplate.opsForZSet().score(CACHE_KEY, key));
            return redisTemplate.opsForValue().get(key);
        }
        return null;
    }

    public Set<String> getValue() {
        Set<String> keysToRemove = redisTemplate.opsForZSet().range(CACHE_KEY, 0, -100-1);
        return keysToRemove;
    }


    private void cleanup() {
        Set<String> keysToRemove = redisTemplate.opsForZSet().range(CACHE_KEY, 0, -MAX_CACHE_SIZE - 1);
        if (keysToRemove != null && !keysToRemove.isEmpty()) {
            redisTemplate.delete(keysToRemove);
            redisTemplate.opsForZSet().remove(CACHE_KEY, keysToRemove.toArray(new String[0]));
        }
    }
}
