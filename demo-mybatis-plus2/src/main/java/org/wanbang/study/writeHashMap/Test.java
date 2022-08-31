package org.wanbang.study.writeHashMap;

import com.alibaba.schedulerx.shade.scala.collection.mutable.HashTable;
import org.wanbang.study.writeHashMap.util.MyHashMap;

import java.util.Hashtable;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/31 17:20
* @version 1.0
*/

public class Test {
    public static void main(String[] args) {
        MyHashMap<String, String> objectObjectMyHashMap = new MyHashMap<>();
        objectObjectMyHashMap.put("xx1","2");
        objectObjectMyHashMap.put("1","5");
        System.out.println("链表连在下一个节点下面了");

        objectObjectMyHashMap.put("xx1","3");

        String value = (String) objectObjectMyHashMap.get("xx1");
        System.out.println(value);




        Hashtable ht = new Hashtable();
        ht.put("1","2");
        System.out.println("hashTable是 在 put 的时候 对整个 put方法加锁 - synchronized");
    }
}
