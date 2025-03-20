package org.wanbang.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wanbang.entity.User;
import org.wanbang.service.UserService;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;

/**
 * (SpringWord)表控制层
 *
 * @author makejava
 * @since 2022-06-16 10:17:35
 */
@Slf4j
@RestController
@RequestMapping("springWordTest10")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/selectOne")
    public String selectOne() {
        User user = userService.queryById((long) 1);
        return JSON.toJSONString(user);
    }

    @GetMapping("/selectTwo")
    public String selectTwo() throws InterruptedException {
        int numThreads = 5;
        // 用于控制线程同时开始
        CountDownLatch startLatch = new CountDownLatch(1);
        // 用于等待所有线程完成
        CountDownLatch endLatch = new CountDownLatch(numThreads);

        // 创建多个线程
        for (int i = 0; i < numThreads; i++) {
            int threadId = i;
            new Thread(() -> {
                try {
                    startLatch.await(); // 等待主线程发出开始信号

                    // 集控器上电
//                    ForwardCtcMqttToMqMessage forwardCtcMqttToMqMessage = new ForwardCtcMqttToMqMessage();
//                    mqttTopicOnlineHandler.handleMessage(forwardCtcMqttToMqMessage);
                    testMethod();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    endLatch.countDown(); // 标记当前线程完成
                }
            }).start();
        }

        System.out.println("All threads are ready, starting concurrent execution...");
        // 释放所有线程，开始并发执行
        startLatch.countDown();

        // 等待所有线程完成
        endLatch.await();
        System.out.println("All threads have finished execution.");
        return null;
    }

    @GetMapping("/insetOne")
    public Integer insetOne() {
        Integer count = userService.insertData();
        return count;
    }

    private void testMethod() {
        System.out.println("123");
    }


}

