package com.example.log.collection.service2.controller;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class DemoController {

    @GetMapping("/demo/getlist")
    public List<String> getlist() {
        log.info("进入了接口");
        List<String> list = asList("demo1", "demo1", "demo3");
        log.info("测试日志的信息");
        return list;
    }


    @GetMapping("/demo/getlist2")
    public List<String> getlist2() {
        log.info("通过了其他的服务请求过来");
        List<String> list = asList("haha", "hehe", "youyou");
        log.info("请求完了");
        return list;
    }
}