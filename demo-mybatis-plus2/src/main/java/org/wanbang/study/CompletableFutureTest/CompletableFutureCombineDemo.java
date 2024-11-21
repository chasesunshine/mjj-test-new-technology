package org.wanbang.study.CompletableFutureTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 3. 异步任务组合
 */
public class CompletableFutureCombineDemo {

    public static void main(String[] args) {
        // 创建两个独立的 CompletableFuture
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "World";
        });

        // 组合两个 CompletableFuture 的结果
        CompletableFuture<String> combinedFuture = future1.thenCombine(future2, (result1, result2) -> {
            return result1 + " " + result2;
        });

        // 添加回调，处理组合结果
        combinedFuture.thenAccept(result -> {
            System.out.println("Combined result: " + result);
        });

        // 阻塞等待组合结果
        try {
            System.out.println("Combined result: " + combinedFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}