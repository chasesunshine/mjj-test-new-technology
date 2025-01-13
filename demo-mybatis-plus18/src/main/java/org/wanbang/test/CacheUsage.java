package org.wanbang.test;

import org.wanbang.config.GuavaRedisCache;
import redis.clients.jedis.Jedis;

public class CacheUsage {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        GuavaRedisCache cache = new GuavaRedisCache(3600, jedis);

        // 获取数据
        String value = cache.get("myKey");
        if (value == null) {
            // 缓存未命中，需要从数据库或其他数据源获取数据
            value = "myValue";
            cache.put("myKey", value);
        }

        // 更新数据
        cache.put("myKey", "newValue");

        // 删除缓存数据
        cache.invalidate("myKey");

        // 关闭缓存
        cache.close();
        jedis.close();
    }
}
