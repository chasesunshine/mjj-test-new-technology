package org.wanbang.study.allDesignMode.constructMode.flyWeightMode.util;
/**
* @description: TODO
* @author majiajian
* @date 2022/8/17 17:52
* @version 1.0
*/

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成⻓，让⾃⼰和他⼈都能有所收获！
 * 公众号：bugstack⾍洞栈
 * Create by ⼩傅哥(fustack) @2020
 */
public class RedisUtils {
    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
    private AtomicInteger stock = new AtomicInteger(0);

    public RedisUtils() {scheduledExecutorService.scheduleAtFixedRate(() -> {
            // 模拟库存消耗
            stock.addAndGet(1);
        }, 0, 100000, TimeUnit.MICROSECONDS);
    }

    public int getStockUsed() {
        return stock.get();
    }
}
