package org.wanbang.util.redis.lock;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * @author chasesunshine
 */
@Component
@AllArgsConstructor
@Slf4j
public class LockExecutor2 {

    private final RedissonClient redissonClient;

    public <T>T exec(String lockKey, long seconds, Supplier<T> supplier) throws Exception {

        RLock lock = redissonClient.getLock(lockKey);
        if (lock.isLocked()) {
            throw new RuntimeException("获取锁失败");
        }

        try {
            if (lock.tryLock(seconds, TimeUnit.SECONDS)) {
                return supplier.get();
            } else {
                throw new RuntimeException("获取锁失败");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException("获取锁失败");
        } finally {
            lock.unlock();
        }

    }

}