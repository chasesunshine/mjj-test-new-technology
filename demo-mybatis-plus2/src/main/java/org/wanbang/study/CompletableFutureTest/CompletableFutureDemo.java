package org.wanbang.study.CompletableFutureTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 1. 基本异步操作
 */
public class CompletableFutureDemo {

    public static void main(String[] args) {
        // 创建一个 CompletableFuture，表示一个异步任务
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            // 模拟耗时操作
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello, CompletableFuture!";
        });

        // 添加回调，处理结果
        future.thenAccept(result -> {
            System.out.println("Result: " + result);
        });

        // 阻塞等待结果
        try {
            System.out.println("Final result: " + future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}