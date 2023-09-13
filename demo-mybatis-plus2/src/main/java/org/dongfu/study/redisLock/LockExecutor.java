package org.dongfu.study.redisLock;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
//import org.redisson.api.RLock;
//import org.redisson.api.RedissonClient;
//import org.wanbang.study.redisLock.utils.BusinessException;
//
//import java.util.concurrent.TimeUnit;
//import java.util.function.Supplier;
//import static org.wanbang.study.redisLock.utils.CommonErrorCode.GET_LOCK_ERROR;

@Component
@AllArgsConstructor
@Slf4j
public class LockExecutor {

//    private final RedissonClient redissonClient;
//
//    public <T> T exec(String lockKey, long seconds, Supplier<T> supplier) {
//        RLock lock = redissonClient.getLock(lockKey);
//        if (lock.isLocked()) {
//            throw new BusinessException(GET_LOCK_ERROR);
//        }
//
//        try {
//            if (lock.tryLock(seconds, TimeUnit.SECONDS)) {
//                return supplier.get();
//            }
//            else {
//                throw new BusinessException(GET_LOCK_ERROR);
//            }
//        }
//        catch (InterruptedException e) {
//            throw new BusinessException(GET_LOCK_ERROR);
//        }
//        finally {
//            lock.unlock();
//        }
//    }

}
