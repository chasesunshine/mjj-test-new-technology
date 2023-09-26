package org.wanbang.study.javaCache;

import java.lang.ref.SoftReference;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 使用map做缓存
 */
public class MapCache {
    //定义扫描时间参数
    private static final int CLEAN_TIME_PARAMETER = 5;

    private final ConcurrentHashMap<String, SoftReference<CacheObject>> cache = new ConcurrentHashMap<>();

    /**
     * 在构造函数中，创建一个守护程序线程，每5秒扫描一次并清理过期的对象。
     */
    public MapCache(){
        Thread cleanerThread = new Thread(()->{
            //获取线程中断状态
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(CLEAN_TIME_PARAMETER * 1000);
                    cache.entrySet().removeIf(
                            entry -> Optional.ofNullable(entry.getValue())
                                    .map(SoftReference::get)
                                    .map(CacheObject::isExpired)
                                    .orElse(false)
                    );
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        cleanerThread.setDaemon(true);
        cleanerThread.start();
    }

    public void add(String key, Object value, long periodInMillis) {
        if(key == null){
            return;
        }
        if(value == null){
            cache.remove(key);
        }else {
            long expiryTime = System.currentTimeMillis() + periodInMillis;
            cache.put(key, new SoftReference<>(new CacheObject(value, expiryTime)));
        }
    }

    public void remove(String key) {
        cache.remove(key);
    }

    public Object get(String key) {
        return Optional.ofNullable(cache.get(key)).map(SoftReference::get).filter(cacheObject -> !cacheObject.isExpired()).map(CacheObject::getValue).orElse(null);
    }

    public void clear() {
        cache.clear();
    }

    public long size() {
        return cache.entrySet().stream().filter(entry -> Optional.ofNullable(entry.getValue()).map(SoftReference::get).map(cacheObject -> !cacheObject.isExpired()).orElse(false)).count();
    }


    /**
     * 缓存对象value
     */
    private static class CacheObject {
        private Object value;
        private long expiryTime;

        private CacheObject(Object value, long expiryTime) {
            this.value = value;
            this.expiryTime = expiryTime;
        }

        boolean isExpired() {
            return System.currentTimeMillis() > expiryTime;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }
    }
}

