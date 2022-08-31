package org.wanbang.study.writeHashMap;

import org.wanbang.study.writeHashMap.util.MyHashMap;

import java.util.Hashtable;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/31 17:20
* @version 1.0
*/

public class TestHashTable {
    public static void main(String[] args) {
        Hashtable ht = new Hashtable();
        ht.put("1","2");
        System.out.println("hashTable是 在 put 的时候 对整个 put方法加锁 - synchronized");
    }
}
