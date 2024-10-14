package org.wanbang.redisapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RedisUtil {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * getExpire 方法的返回值：
     * -1 表示 key 存在但没有设置过期时间。
     * -2 表示 key 不存在。
     * 正整数表示 key 的剩余过期时间（以秒为单位）。
     *
     * @param key
     * @return
     */
    public long getKeyTTL(String key) {
        return redisTemplate.getExpire(key);
    }
}
