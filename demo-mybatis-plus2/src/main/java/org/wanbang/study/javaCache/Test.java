package org.wanbang.study.javaCache;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        MapCache mapCache = new MapCache();
        mapCache.add("10001", "111111", 5 * 1000);
        mapCache.add("10002", "222222", 5 * 1000);
        mapCache.add("10003", "333333", 5 * 1000);
        System.out.println("从缓存中取出值:" + mapCache.get("10001"));
        Thread.sleep(5000L);
        System.out.println("5秒钟过后");
        // 5秒后数据自动清除了
        System.out.println("从缓存中取出值:" + mapCache.get("10001"));

    }
}


