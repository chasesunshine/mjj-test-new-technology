package org.wanbang.util.raft;

import java.util.concurrent.*;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class RateLimitedRaftRequestHandler {

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final ConcurrentHashMap<String, Request> requestCache = new ConcurrentHashMap<>();
    private final AtomicBoolean processing = new AtomicBoolean(false);

    public RateLimitedRaftRequestHandler() {
        // 每隔一秒钟检查并处理最后的请求
        scheduler.scheduleAtFixedRate(this::processLastRequest, 1, 1, TimeUnit.SECONDS);
    }

    public void submitRequest(Request request) {
        // 将新请求放入缓存中，覆盖旧请求
        requestCache.put(request.getId(), request);
        System.out.println("Received request: " + request.getId());
    }

    private void processLastRequest() {
        if (processing.compareAndSet(false, true)) {
            try {
                // 获取当前缓存中的所有请求副本
                Map<String, Request> requestsCopy;
                synchronized (requestCache) {
                    requestsCopy = new ConcurrentHashMap<>(requestCache);
                    requestCache.clear(); // 清空缓存以便接收新的请求
                }

                // 处理最后一个请求（这里假设ID可以用来确定顺序）
                Request lastRequest = null;
                for (Request req : requestsCopy.values()) {
                    lastRequest = req; // 假设最新的请求会最后被添加到map中
                }

                if (lastRequest != null) {
                    handleRequest(lastRequest);
                }
            } finally {
                processing.set(false);
            }
        }
    }

    private void handleRequest(Request request) {
        // 处理请求的逻辑
        System.out.println("Processing last request: " + request.getId());
        // 在这里执行实际的请求处理逻辑...
    }

    public static void main(String[] args) throws InterruptedException {
        RateLimitedRaftRequestHandler handler = new RateLimitedRaftRequestHandler();

        // 模拟提交多个请求
        for (int i = 0; i < 5; i++) {
            Thread.sleep(200); // 模拟不同步到达的请求
            handler.submitRequest(new Request("req-" + i));
        }

        // 让程序运行足够长的时间以观察结果
        Thread.sleep(5000);
        handler.scheduler.shutdown();
    }

    // 请求类的简单模拟
    static class Request {
        private final String id;

        public Request(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}
