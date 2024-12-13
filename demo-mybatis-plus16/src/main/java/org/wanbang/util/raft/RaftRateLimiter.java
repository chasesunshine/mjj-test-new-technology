package org.wanbang.util.raft;

import org.wanbang.param.Request;

import java.util.concurrent.*;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class RaftRateLimiter {

    private static final long INTERVAL = 1000; // 限流时间间隔为1秒
    private final Map<String, Request> requestMap = new ConcurrentHashMap<>();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final ReentrantLock lock = new ReentrantLock();

    public RaftRateLimiter() {
        // 每隔INTERVAL毫秒触发一次清理和处理任务
        scheduler.scheduleAtFixedRate(this::processRequests, INTERVAL, INTERVAL, TimeUnit.MILLISECONDS);
    }

    public void addRequest(String identifier, String data) {
        // 在每次添加新请求时更新对应identifier的最后一份请求
        lock.lock();
        try {
            requestMap.put(identifier, new Request(data, System.currentTimeMillis()));
        } finally {
            lock.unlock();
        }
    }

    private void processRequests() {
        long currentTime = System.currentTimeMillis();
        lock.lock();
        try {
            for (Map.Entry<String, Request> entry : requestMap.entrySet()) {
                if (currentTime - entry.getValue().getTimestamp() >= INTERVAL) {
                    // 处理最后一份请求并从map中移除
                    raftProcessRequest(entry.getValue());
                    requestMap.remove(entry.getKey());
                }
            }
        } finally {
            lock.unlock();
        }
    }

    private void raftProcessRequest(Request request) {
        // 模拟向Raft提交请求的逻辑
        System.out.println("Processing request: " + request.getData());
    }

}
