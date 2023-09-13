package org.dongfu.study.springEvent.simple.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.dongfu.study.springEvent.simple.event.CustomEvent;

import javax.annotation.Resource;

/**
* @description: 调用层
* @author majiajian
* @date 2022/12/7 12:59
* @version 1.0
*/

@RestController
public class HelloController {

    @Resource
    private ApplicationContext applicationContext;

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("事件开始发布消息："+System.currentTimeMillis());
        applicationContext.publishEvent(new CustomEvent(this,"你好啊"));

        return "success";
    }
}
