package org.wanbang.study.CompletableFutureTest;

import org.wanbang.study.allDesignMode.behaviorMode.brokeMode.po.User;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 2. 异步任务链式调用
 */
public class CompletableFutureChainDemo {

    public static void main(String[] args) {
        // 创建第一个 CompletableFuture
        CompletableFuture<User> future1 = CompletableFuture.supplyAsync(() -> {
            User user = new User();
            user.setName("majiajian");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return user;
        });

        // 创建第二个 CompletableFuture，依赖于第一个 CompletableFuture 的结果
        CompletableFuture<String> future2 = future1.thenApplyAsync(result -> {
            return result.getName() + ", World!";
        });

        // 创建第三个 CompletableFuture，依赖于第二个 CompletableFuture 的结果
        CompletableFuture<String> future3 = future2.thenApplyAsync(result -> {
            return result + " from CompletableFuture!";
        });

        // 添加回调，处理最终结果
        future3.thenAccept(result -> {
            System.out.println("Final result: " + result);
        });

        // 阻塞等待最终结果
        try {
            System.out.println("Final result: " + future3.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
