package org.wanbang.apilimit;

import java.util.concurrent.*;

public class AsyncApiCaller {
    private static final ExecutorService executor = Executors.newCachedThreadPool();

    public static String callApiWithTimeout() {
        Future<String> future = executor.submit(() -> {
            // 这里放置实际的API调用代码
            return callExternalApi();
        });

        try {
            return future.get(3, TimeUnit.SECONDS); // 等待最多3秒
        } catch (TimeoutException e) {
            future.cancel(true); // 取消任务
            return "API调用超时";
        } catch (Exception e) {
            return "调用出错: " + e.getMessage();
        }
    }

    private static String callExternalApi() {
        // 延迟4s
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println("2222");
        }

        // 实际的API调用逻辑
        return "API响应";
    }

    public static void main(String[] args) {
        String s = callApiWithTimeout();
        System.out.println(s);
    }
}
