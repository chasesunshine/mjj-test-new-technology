package org.wanbang.redislock;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.wanbang.redislock.response.BizException;
import org.wanbang.redislock.response.SingleResponse;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 分布式锁
 */
@Slf4j
@Component
public class RedisLock {

    /**
     * simple lock尝试获取锅的次数
     */
    private static final int retryCount = 3;
    /**
     * 每次尝试获取锁的重试间隔毫秒数
     */
    private static final int waitIntervalInMSTo = 50;

    /**
     * redis锁 前缀
     */
    private static final String REDISLOCK_PREFIX = "HOME_ANALYSIS:";

    /**
     * 生成预占库存同步锁key-value
     *
     * @return
     */
    private String[] genLock(String keyword) {
        String[] locks = new String[2];
        locks[0] = StringUtils.join(REDISLOCK_PREFIX, keyword);
        locks[1] = UUID.randomUUID().toString().replaceAll("-", "");
        return locks;
    }

    /**
     *
     *
     * @param redisKey
     * @param lockValue
     * @param expireTime
     * @param timeUnit
     * @return
     */
    private boolean simpleLock(final String redisKey, final String lockValue, final long expireTime, final TimeUnit timeUnit) {
        try {
            if (StringUtils.isAnyBlank(redisKey, lockValue)) {
                log.warn("redisKey or lockValue is empty!");
                return false;
            }
            if (expireTime <= 0) {
                log.warn("expireInSecond must be bigger than 0");
                return false;
            }

            for (int i = 0; i < retryCount; i++) {
                boolean result = RedisUtils.setIfAbsent(redisKey, lockValue, expireTime, timeUnit);
                if (result) {
                    log.info("redisKey={},value={},expireTime={}s", redisKey, RedisUtils.get(redisKey), expireTime);
                    return true;
                }
                try {
                    //redis锁获取失败时，每隔50毫秒重试获取一次，最多重试3次
                    TimeUnit.MILLISECONDS.sleep(waitIntervalInMSTo);
                } catch (Exception ignore) {
                    log.warn("redis lock fail: " + ignore.getMessage());
                }
            }
        } catch (Exception e) {
            log.error("redis锁获取失败！", e);
        }
        return false;
    }

    /**
     * 锁释放
     *
     * @param redisKey
     * @param lockValue
     */
    private void unlock(final String redisKey, final String lockValue) {
        if (StringUtils.isAnyBlank(redisKey, lockValue)) {
            return;
        }
        try {
            String currLockVal = RedisUtils.get(redisKey);
            if (StringUtils.isNotBlank(currLockVal) && currLockVal.equals(lockValue)) {
                boolean result = RedisUtils.delete(redisKey);
                if (!result) {
                    log.warn(Thread.currentThread().getName() + " unlock redis lock fail");
                } else {
                    log.info(Thread.currentThread().getName() + " unlock redis lock:" + redisKey + " successfully!");
                }
            }
        } catch (Exception je) {
            log.warn(Thread.currentThread().getName() + " unlock redis lock error:" + je.getMessage());
        }
    }

    /**
     * 锁释放
     *
     * @param locks
     */
    private void unlock(final String[] locks) {
        unlock(locks[0], locks[1]);
    }

    /**
     * 带返回值的接口并发锁
     *
     * @param fxWith   接口逻辑
     * @param cacheKey key
     * @return Response
     */
    public <T> SingleResponse<T> tryConcurrentLock(SrmWithError<T> fxWith, CacheKey cacheKey) {
        String[] locks = this.genLock(cacheKey.getKey());
        try {
            //1.reids加锁
            if (this.simpleLock(locks[0], locks[1], cacheKey.getExpire().getSeconds(), TimeUnit.SECONDS)) {
                return fxWith.execute();
            }
            return SingleResponse.fail("正在处理中，请稍后重试！");
        } catch (BizException e) {
            log.warn("tryConcurrentLock DistributionException!", e);
            return SingleResponse.fail(e.getMessage());
        } catch (Exception e) {
            log.warn("tryConcurrentLock error!", e);
            return SingleResponse.fail(e.getMessage());
        } finally {
            this.unlock(locks);
        }
    }

    /**
     * @author huangchuang
     */
    @FunctionalInterface
    public interface SrmWithError<T> {

        /**
         * @return
         * @throws BizException
         */
        SingleResponse<T> execute() throws Exception;

    }

}