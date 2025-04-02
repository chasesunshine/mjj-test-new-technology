package org.wanbang.fixedwindow;

import redis.clients.jedis.Jedis;
import java.util.stream.Collectors;
import java.util.List;

/**
 * 三、滑动窗口限流
 * 滑动窗口限流能够更精确地控制请求速率，避免固定窗口算法中临界点的突发流量问题。
 * 1. 实现逻辑
 * 滑动窗口限流记录每个请求的时间戳，并在每次请求时清理过期的记录。
 */

/**
 * 个人理解： jedis.zadd(sliding_rate_limit:user123, 1743575500, String.valueOf(currentTime))
 *          jedis.zadd(sliding_rate_limit:user123, 1743575526, String.valueOf(currentTime))
 *
 * 在 Redis 的 ZADD 命令 ZADD(String key, double score, String member) 中，key 可以一致的原因是因为：
 * 1. 有序集合(Sorted Set)的数据结构特性：每个 key 对应一个独立的有序集合，同一个 key 下的不同 member 可以有相同或不同的 score。
 * 2.  成员唯一性：在同一个 key 对应的有序集合中，每个 member 必须是唯一的。如果你对同一个 key 和 member 多次使用 ZADD，效果是：
 *      如果 member 不存在：添加新成员
 *      如果 member 已存在：更新该成员的 score
 */
public class SlidingWindowRateLimiter {
    private static final String REDIS_HOST = "localhost";
    private static final int REDIS_PORT = 6379;
    private static final int LIMIT = 10; // 每窗口的最大请求数
    private static final int WINDOW_SIZE = 10; // 窗口大小（秒）

    private Jedis jedis;

    public SlidingWindowRateLimiter() {
        this.jedis = new Jedis(REDIS_HOST, REDIS_PORT);
    }

    public boolean isAllowed(String userId) {
        // 表示的是秒
        long currentTime = System.currentTimeMillis() / 1000;
        System.out.println("currentTime:"+ currentTime);
        // 当前秒 减去 60s
        long windowStart = currentTime - WINDOW_SIZE;
        System.out.println("windowStart:"+ windowStart);

        String key = "sliding_rate_limit:" + userId;
        // 清理过期请求 , 删除所有满足 start ≤ score ≤ end 的成员。
        // key	String	有序集合的键名。
        // start	double	分数范围的最小值（闭区间，包含边界），例如 100.0 表示 score ≥ 100.0。
        // end	double	分数范围的最大值（闭区间，包含边界），例如 200.0 表示 score ≤ 200.0。
        jedis.zremrangeByScore(key, 0, windowStart);

        // 获取当前窗口内的请求数量
        long count = jedis.zcard(key);
        System.out.println("count:"+count);
        if (count < LIMIT) {
            jedis.zadd(key, currentTime, String.valueOf(currentTime));
            jedis.expire(key, WINDOW_SIZE);
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SlidingWindowRateLimiter limiter = new SlidingWindowRateLimiter();
        String userId = "user123";

        for (int i = 0; i < 20; i++) {
            if(i == 10){
                Thread.sleep(1000);
            }
            System.out.println("Request " + (i + 1) + ": " + limiter.isAllowed(userId));
        }
    }
}
