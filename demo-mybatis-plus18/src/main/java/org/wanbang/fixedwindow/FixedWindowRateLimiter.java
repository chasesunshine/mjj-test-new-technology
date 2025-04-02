package org.wanbang.fixedwindow;

import redis.clients.jedis.Jedis;

/**
 * 固定窗口限流是最简单的限流算法。它将时间划分为固定的窗口，每个窗口内限制请求次数。
 * 1. 实现逻辑
 * 每当一个请求到达时，检查当前窗口内的请求数量是否超过限制。如果未超过，则允许请求并增加计数；否则，拒绝请求。
 *
 */

/**
 * 个人理解：
 * redis中存的： 第一次   rate_limit：user123：当前分钟 ， 1
 *             第二次   rate_limit：user123：当前分钟 ， 2
 *             第二次   rate_limit：user123：当前分钟 ， 3
 */
public class FixedWindowRateLimiter {
    private static final String REDIS_HOST = "localhost";
    private static final int REDIS_PORT = 6379;
    private static final int LIMIT = 10; // 每窗口的最大请求数
    private static final int WINDOW_SIZE = 60; // 窗口大小（秒）

    private Jedis jedis;

    public FixedWindowRateLimiter() {
        this.jedis = new Jedis(REDIS_HOST, REDIS_PORT);
    }

    public boolean isAllowed(String userId) {
        String key = "rate_limit:" + userId;
        // System.currentTimeMillis() / 1000 表示秒  / WINDOW_SIZE 表示的是分钟
        long currentWindow = System.currentTimeMillis() / 1000 / WINDOW_SIZE;
        String windowKey = key + ":" + currentWindow;

        if (jedis.exists(windowKey)) {
            if (Integer.parseInt(jedis.get(windowKey)) < LIMIT) {
                jedis.incr(windowKey);
                return true;
            } else {
                return false;
            }
        } else {
            jedis.setex(windowKey, WINDOW_SIZE, "1");
            return true;
        }
    }

    public static void main(String[] args) {
        FixedWindowRateLimiter limiter = new FixedWindowRateLimiter();
        String userId = "user123";

        for (int i = 0; i < 15; i++) {
            System.out.println("Request " + (i + 1) + ": " + limiter.isAllowed(userId));
        }
    }
}