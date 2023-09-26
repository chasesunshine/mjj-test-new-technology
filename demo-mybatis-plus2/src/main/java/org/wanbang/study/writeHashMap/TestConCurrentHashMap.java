package org.wanbang.study.writeHashMap;

import java.util.concurrent.ConcurrentHashMap;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/31 17:20
* @version 1.0
*/

public class TestConCurrentHashMap {
    public static void main(String[] args) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap<>();

        // 去看put源码  -  casTabAt(tab, i, null, new Node<K,V>(hash, key, value, null))
        concurrentHashMap.put("1","2");

        System.out.println("底层是数组+链表 , 对数组中某一个 node节点 进行 synchronized 加锁");
    }
}
