package org.wanbang.controller;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/27 11:06
* @version 1.0
*/

public class TestController {
    public static void main(String[] args) {
        List<String> listAll= new ArrayList<>();

        List<String> list1= new ArrayList<>();
        List<String> list2= new ArrayList<>();

        list1.add("1");
        list1.add("2");
        list1.add("3");

        listAll.addAll(list1);

        list2.add("4");
        list2.add("5");
        list2.add("6");

        listAll.addAll(list2);

        System.out.println(JSON.toJSONString(listAll));
    }
}
