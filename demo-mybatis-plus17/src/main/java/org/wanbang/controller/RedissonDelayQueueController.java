package org.wanbang.controller;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.*;
import org.wanbang.entity.UserInfo;
import org.wanbang.redissondelayqueue.OrderTimeoutService;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * 描述: 延迟队列测试 <br>
 * 作者: IT学习道场 <br>
 * 时间: 2022/8/05 14:16
 */
@RequestMapping("/redissonDelayQueue")
@RestController
public class RedissonDelayQueueController {
    @Resource
    private RedissonClient redissonClient;

    @GetMapping("/dealwithOrder")
    public void dealwithOrder() throws InterruptedException {
        // 创建订单超时服务
        OrderTimeoutService orderTimeoutService = new OrderTimeoutService(redissonClient);

        // 启动消费者线程
        orderTimeoutService.startConsumer();
        // 模拟添加订单到延迟队列
        orderTimeoutService.addOrder("order_1", 10, TimeUnit.SECONDS); // 10秒后超时
        orderTimeoutService.addOrder("order_2", 30, TimeUnit.SECONDS); // 30秒后超时

        // 模拟程序运行
        Thread.sleep(20000); // 等待40秒

        orderTimeoutService.dealwithOrder("order_2");
        // 关闭服务
//        orderTimeoutService.shutdown();
    }

}
