package org.wanbang.study.CountDownLaunchTest.Test2;

import java.util.concurrent.CountDownLatch;

public class InitializationExample {

    public static void main(String[] args) throws InterruptedException {
        int initTasks = 3;
        final CountDownLatch latch = new CountDownLatch(initTasks);

        // 数据库初始化
        new Thread(() -> {
            initializeDatabase();
            System.out.println("数据库初始化完成");
            latch.countDown();
        }).start();

        // 缓存初始化
        new Thread(() -> {
            initializeCache();
            System.out.println("缓存初始化完成");
            latch.countDown();
        }).start();

        // 配置文件加载
        new Thread(() -> {
            loadConfigurations();
            System.out.println("配置文件加载完成");
            latch.countDown();
        }).start();

        // 等待所有初始化任务完成
        latch.await();
        System.out.println("所有初始化任务已完成，系统准备就绪...");
    }

    private static void initializeDatabase() {
        // 初始化数据库逻辑
    }

    private static void initializeCache() {
        // 初始化缓存逻辑
    }

    private static void loadConfigurations() {
        // 加载配置文件逻辑
    }
}