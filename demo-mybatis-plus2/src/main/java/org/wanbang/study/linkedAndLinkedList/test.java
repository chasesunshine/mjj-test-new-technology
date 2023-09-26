package org.wanbang.study.linkedAndLinkedList;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;

public class test {
    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            integers.add(i);
        }
        System.out.println(JSON.toJSONString(integers));
    }
}
