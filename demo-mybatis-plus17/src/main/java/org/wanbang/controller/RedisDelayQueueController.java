package org.wanbang.controller;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wanbang.delayqueue.constant.RedisDelayQueueEnum;
import org.wanbang.delayqueue.util.RedisDelayQueueUtil;
import org.wanbang.entity.Comment;
import org.wanbang.entity.Order;
import org.wanbang.entity.UserInfo;

import java.time.Duration;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/**
 * 描述: 延迟队列测试 <br>
 * 作者: IT学习道场 <br>
 * 时间: 2022/8/05 14:16
 */
@RequestMapping("/redisDelayQueue")
@RestController
public class RedisDelayQueueController {
    @Autowired
    private RedisDelayQueueUtil redisDelayQueueUtil;

    @PostMapping("/addQueue")
    public void addQueue(@RequestBody UserInfo userInfo) {
        Date date1 = new Date();
        // 获取当前时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        // 模拟 倒计时开始时间
        calendar.add(Calendar.SECOND, -50);
        // 获取延迟后的Date对象
        Date startTime = calendar.getTime();

        Instant instant1 = date1.toInstant();
        Instant instant2 = startTime.toInstant();
        // 计算两个 Instant 之间的持续时间
        Duration duration = Duration.between(instant2, instant1);
        // 获取时间差，以秒为单位
        long secondsDifference = duration.getSeconds();
        long delayTime = userInfo.getInterval() * 60 - secondsDifference;

        redisDelayQueueUtil.addDelayQueue(userInfo, delayTime, TimeUnit.SECONDS, RedisDelayQueueEnum.orderPaymentTimeout.getCode());
    }

    @PostMapping("/addQueu2")
    public void addQueue2(@RequestBody UserInfo userInfo) throws ClassNotFoundException {
        Date date1 = new Date();
        // 获取当前时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        // 模拟 倒计时开始时间
        calendar.add(Calendar.SECOND, -45);
        // 获取延迟后的Date对象
        Date startTime = calendar.getTime();

        Instant instant1 = date1.toInstant();
        Instant instant2 = startTime.toInstant();
        // 计算两个 Instant 之间的持续时间
        Duration duration = Duration.between(instant2, instant1);
        // 获取时间差，以秒为单位
        long secondsDifference = duration.getSeconds();
        long delayTime = userInfo.getInterval() * 60 - secondsDifference;

        redisDelayQueueUtil.addDelayQueue(userInfo, delayTime, TimeUnit.SECONDS, RedisDelayQueueEnum.orderPaymentTimeout.getCode());
    }


//    @PostMapping("/addQueue3")
//    public void addQueue() throws ClassNotFoundException {
//        Order order1 = new Order(1, "订单支付1超时，自动取消订单");
//        Order order2 = new Order(2, "订单支付2超时，自动取消订单");
//        Order order3 = new Order(3, "订单支付3超时，自动取消订单");
//        String string = "{\"orderId\": 5,\"remark\": \"短发女生的烦恼\"}";
//        Class<?> clazz = Class.forName("org.wanbang.entity.Order");
//        Object object = JSON.parseObject(string, clazz);
//        Comment comment = new Comment(4, "订单超时未评价，系统默认好评");
//        // 添加订单支付超时，自动取消订单延迟队列。为了测试效果，延迟10秒钟
//        redisDelayQueueUtil.addDelayQueue(order1, 10, TimeUnit.SECONDS, RedisDelayQueueEnum.orderPaymentTimeout.getCode());
//        // 添加订单支付超时，自动取消订单延迟队列。为了测试效果，延迟10秒钟
//        redisDelayQueueUtil.addDelayQueue(order2, 10, TimeUnit.SECONDS, RedisDelayQueueEnum.orderPaymentTimeout.getCode());
//        // 添加订单支付超时，自动取消订单延迟队列。为了测试效果，延迟10秒钟
//        redisDelayQueueUtil.addDelayQueue(order3, 30, TimeUnit.SECONDS, RedisDelayQueueEnum.orderPaymentTimeout.getCode());
//        // 添加订单支付超时，自动取消订单延迟队列。为了测试效果，延迟10秒钟
//        redisDelayQueueUtil.addDelayQueue(object, 40, TimeUnit.SECONDS, RedisDelayQueueEnum.orderPaymentTimeout.getCode());
//        // 订单超时未评价，系统默认好评。为了测试效果，延迟20秒钟
//        redisDelayQueueUtil.addDelayQueue(comment, 50, TimeUnit.SECONDS, RedisDelayQueueEnum.orderNotEvaluatedTimeout.getCode());
//    }

}
