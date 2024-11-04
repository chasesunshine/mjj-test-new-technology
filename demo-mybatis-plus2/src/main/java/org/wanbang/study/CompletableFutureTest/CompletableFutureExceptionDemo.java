package org.wanbang.study.CompletableFutureTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 4. 异步任务异常处理
 */
public class CompletableFutureExceptionDemo {

    public static void main(String[] args) {
        // 创建一个 CompletableFuture，模拟一个会抛出异常的任务
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            if (true) {
                throw new RuntimeException("Something went wrong!");
            }
            return "Hello, CompletableFuture!";
        });

        // 添加异常处理回调
        CompletableFuture<String> handledFuture = future.handle((result, ex) -> {
            if (ex != null) {
                System.out.println("Exception occurred: " + ex.getMessage());
                return "Default Value";
            } else {
                return result;
            }
        });

        // 添加回调，处理最终结果
        handledFuture.thenAccept(result -> {
            System.out.println("Final result: " + result);
        });

        // 阻塞等待最终结果
        try {
            System.out.println("Final result: " + handledFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
