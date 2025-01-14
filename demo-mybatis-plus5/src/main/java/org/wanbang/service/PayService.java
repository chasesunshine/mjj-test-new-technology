package org.wanbang.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
public class PayService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private final int totalNum = 100000;
    private int sum = 0;

    // maxAttempts 包括了第一次的处理尝试
    // 第一次：延时 2 s ， 第二次：延时 2*1.5 s  第三次：延时 2*1.5*1.5 s
    // (注，重试捕获返回参数要一致 recover 和 minGoodsnum 返回的参数要一致)
    @Retryable(value = Exception.class, maxAttempts = 3, backoff = @Backoff(delay = 2000L, multiplier = 1.5))
    public int minGoodsnum(int num) throws Exception {
        sum = sum +1;
        if(sum >3){
            sum = 1;
        }
        log.info("第 {} 次",sum);

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        logger.info("时间：{}",formattedDateTime);

        //模拟处理支付的逻辑，如果发生 PaymentException 则会进行重试
        if (true) {
            throw new Exception("Payment processing failed.");
        }
        logger.info("处理成功");
        return totalNum - num;
    }

    @Recover
    public int recover(Exception e) {
        logger.warn("异常打印！！！" + LocalTime.now());
        //记日志到数据库
        return totalNum;
    }
}