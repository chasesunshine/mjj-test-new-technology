package org.dongfu.study.writeHashMap.jdk8;

import org.dongfu.study.writeHashMap.jdk8.util.ImitatedWritingHashMap;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/31 19:37
* @version 1.0
*/

public class Test {
    public static void main(String[] args) {
        ImitatedWritingHashMap<String ,String> hashMap = new ImitatedWritingHashMap<>();
        hashMap.put("1","2");

        System.out.println(hashMap.get("1"));
    }
}
