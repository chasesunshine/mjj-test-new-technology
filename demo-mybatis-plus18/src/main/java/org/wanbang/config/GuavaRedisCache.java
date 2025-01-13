package org.wanbang.config;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import redis.clients.jedis.Jedis;

import java.util.concurrent.TimeUnit;

public class GuavaRedisCache {

    private final LoadingCache<String, String> cache;
    private final Jedis jedis;

    public GuavaRedisCache(int expireAfterWriteSeconds, Jedis jedis) {
        this.jedis = jedis;
        this.cache = CacheBuilder.newBuilder()
                .expireAfterWrite(expireAfterWriteSeconds, TimeUnit.SECONDS)
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        // 当缓存未命中时，从Redis加载数据
                        return jedis.get(key);
                    }
                });
    }

    public String get(String key) {
        try {
            return cache.get(key);
        } catch (Exception e) {
            // 处理异常
            return null;
        }
    }

    public void put(String key, String value) {
        // 更新Redis和Guava缓存
        jedis.set(key, value);
        cache.put(key, value);
    }

    public void invalidate(String key) {
        // 从Guava缓存中删除条目
        cache.invalidate(key);
        // 同时删除Redis中的数据
        jedis.del(key);
    }

    public void close() {
        // 关闭资源
        cache.cleanUp();
        jedis.close();
    }
}
