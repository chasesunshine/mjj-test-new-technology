package org.wanbang.util.raft;

import com.alibaba.fastjson.JSON;
import org.wanbang.param.RequestParam;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class RateLimitedRaftRequestHandler2 {

    public final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final ConcurrentHashMap<String, RequestParam> requestCache = new ConcurrentHashMap<>();
    private final AtomicBoolean processing = new AtomicBoolean(false);

    public RateLimitedRaftRequestHandler2() {
        // 每隔一秒钟检查并处理最后的请求
        scheduler.scheduleAtFixedRate(this::processLastRequest, 1, 1, TimeUnit.SECONDS);
    }

    public void submitRequest(RequestParam requestParam) {
        // 将新请求放入缓存中，覆盖旧请求
        requestCache.put(requestParam.getId().toString(), requestParam);

        System.out.println("Received request: " + JSON.toJSONString(requestParam));
    }

    private void processLastRequest() {
        if (processing.compareAndSet(false, true)) {
            try {
                // 获取当前缓存中的所有请求副本
                Map<String, RequestParam> requestsCopy;
                synchronized (requestCache) {
                    requestsCopy = new ConcurrentHashMap<>(requestCache);
                    requestCache.clear(); // 清空缓存以便接收新的请求
                }

                // 处理最后一个请求（这里假设ID可以用来确定顺序）
                RequestParam lastRequestParam = null;
                for (RequestParam req : requestsCopy.values()) {
                    lastRequestParam = req; // 假设最新的请求会最后被添加到map中
                }

                if (lastRequestParam != null) {
                    handleRequest(lastRequestParam);
                }
            } finally {
                processing.set(false);
            }
        }
    }

    private void handleRequest(RequestParam requestParam) {
        // 处理请求的逻辑
        System.out.println("Processing last request: " + JSON.toJSONString(requestParam));

        // 在这里执行实际的请求处理逻辑...
    }
}
