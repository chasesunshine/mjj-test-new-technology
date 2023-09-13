package org.dongfu.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class PayService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private final int totalNum = 100000;

    // 第一次：延时 2 s ， 第二次：延时 2*2.5 s  第三次：延时 2*2.5*2.5 s
    // (注，重试捕获返回参数要一致 recover 和 minGoodsnum 返回的参数要一致)
    @Retryable(value = Exception.class, maxAttempts = 4, backoff = @Backoff(delay = 2000L, multiplier = 2.5))
    public int minGoodsnum(int num) throws Exception {
        logger.info("减库存开始" + LocalTime.now());
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            logger.error("illegal");
        }
        if (num <= 0) {
            throw new IllegalArgumentException("数量不对");
        }
        logger.info("减库存执行结束" + LocalTime.now());
        return totalNum - num;
    }

    @Recover
    public int recover(Exception e) {
        logger.warn("减库存失败！！！" + LocalTime.now());
        //记日志到数据库
        return totalNum;
    }
}