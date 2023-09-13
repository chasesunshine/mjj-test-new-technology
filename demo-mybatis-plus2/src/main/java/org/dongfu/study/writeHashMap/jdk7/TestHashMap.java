package org.dongfu.study.writeHashMap.jdk7;

import org.dongfu.study.writeHashMap.jdk7.util.MyHashMap;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/31 17:20
* @version 1.0
*/

public class TestHashMap {
    public static void main(String[] args) {
        MyHashMap<String, String> objectObjectMyHashMap = new MyHashMap<>();
        objectObjectMyHashMap.put("xx1","2");
        objectObjectMyHashMap.put("1","5");
        System.out.println("链表连在下一个节点下面了");

        objectObjectMyHashMap.put("xx1","3");

        String value = (String) objectObjectMyHashMap.get("xx1");
        System.out.println(value);
    }
}
