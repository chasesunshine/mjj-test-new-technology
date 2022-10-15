package org.wanbang.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wanbang.entity.TestUser1;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/27 11:06
* @version 1.0
*/
@RestController
@RequestMapping("/test")
public class TestController {

    //2)全局捕获异常
    @RequestMapping("/test-error")
    public String testError(int a) {
        int b = 1/a;
        return "success"+b;

    }

    //2)全局捕获异常
    @RequestMapping("/test-error1")
    public String testError1(@RequestBody @Valid TestUser1 testUser1) {
        return "success" + 1;
    }


//    public static void main(String[] args) {
//        List<String> listAll= new ArrayList<>();
//
//        List<String> list1= new ArrayList<>();
//        List<String> list2= new ArrayList<>();
//
//        list1.add("1");
//        list1.add("2");
//        list1.add("3");
//
//        listAll.addAll(list1);
//
//        list2.add("4");
//        list2.add("5");
//        list2.add("6");
//
//        listAll.addAll(list2);
//
//        System.out.println(JSON.toJSONString(listAll));
//    }

//    public static void main(String[] args) {
//        Map<Integer, Long> map = new HashMap<>();
//        map.put(0, 0L);
//        map.put(1, 1L);
//
//        String a = JSON.toJSONString(map);
//
//        map = JSON.parseObject(a, Map.class);
//        Long b = map.get(1);
//    }
}
