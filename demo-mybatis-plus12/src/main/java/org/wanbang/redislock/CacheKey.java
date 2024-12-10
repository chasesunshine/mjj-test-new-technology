package org.wanbang.redislock;

import lombok.Builder;
import lombok.Data;

import java.time.Duration;

/**
 * @Author: huangchuang
 * @CreateTime: 2022/3/24 16:57
 * @Description:
 */
@Data
@Builder
public class CacheKey {

    /**
     * cache key
     */
    private String key;

    /**
     * 获取过期时间
     */
    private Duration expire;
}
