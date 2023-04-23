package com.example.log.collection.serive1.controller;

import com.example.log.collection.serive1.api.service2.DemoApiClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author :XXX
 * @date :2021-02-07 15:21
 * @description :
 */
@RestController
@Slf4j
public class UserController {
    @Autowired
    private DemoApiClient demoApiClient;


    @GetMapping("/user/getlist")
    public List<String> getlist() {
        log.info("测试接口user");
        List<String> list = asList("user1", "user2", "user3");
        log.warn("测测测");
        return list;
    }


    @GetMapping("/user/getlist2")
    public List<String> getlist2() {
        log.info("测试接口getlist2");
        List<String> result = demoApiClient.getlist2();
        log.info("请求Service2中接口成功,返回数据");
        return result;
    }
}