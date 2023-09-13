package org.dongfu.study.springEvent.difficult.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.dongfu.study.springEvent.difficult.config.MainConfig0;
import org.dongfu.study.springEvent.difficult.service.UserRegisterService;

import javax.annotation.Resource;

/**
* @description: 调用层
* @author majiajian
* @date 2022/12/7 12:59
* @version 1.0
*/

@RestController
public class HelloController2 {

    @Resource
    private ApplicationContext applicationContext;

    @RequestMapping("/hello/difficult")
    public void hello(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig0.class);
        //获取用户注册服务
        UserRegisterService userRegisterService = context.getBean(UserRegisterService.class);
        //模拟用户注册
        userRegisterService.registerUser("路人甲Java");
        
    }
}
