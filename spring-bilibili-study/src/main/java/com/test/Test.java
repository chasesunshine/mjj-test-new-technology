package com.test;

import com.spring.ZhouyuApplicationContext;
import com.zhouyu.AppConfig;
import com.zhouyu.service.UserService;

public class Test {
    public static void main(String[] args) {
        ZhouyuApplicationContext zhouyuApplicationContext = new ZhouyuApplicationContext(AppConfig.class);

//        Object userService = zhouyuApplicationContext.getBean("userService");  // map<beanName,bean对象>
//        Object userService1 = zhouyuApplicationContext.getBean("userService");  // map<beanName,bean对象>
//        Object userService2 = zhouyuApplicationContext.getBean("userService");  // map<beanName,bean对象>

//        System.out.println(userService);
//        System.out.println(userService1);
//        System.out.println(userService2);


        UserService userServiceTest = (UserService)zhouyuApplicationContext.getBean("userService");
        userServiceTest.test();

    }
}
