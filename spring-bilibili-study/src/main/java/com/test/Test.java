package com.test;

import com.spring.ZhouyuApplicationContext;
import com.zhouyu.AppConfig;
import com.zhouyu.service.UserService;
import com.zhouyu.service.UserServiceImpl;

public class Test {
    public static void main(String[] args) {
        ZhouyuApplicationContext zhouyuApplicationContext = new ZhouyuApplicationContext(AppConfig.class);

//        Object userService = zhouyuApplicationContext.getBean("userService");  // map<beanName,bean对象>
//        Object userService1 = zhouyuApplicationContext.getBean("userService");  // map<beanName,bean对象>
//        Object userService2 = zhouyuApplicationContext.getBean("userService");  // map<beanName,bean对象>

//        System.out.println(userService);
//        System.out.println(userService1);
//        System.out.println(userService2);


        UserService userServiceImplTest = (UserServiceImpl)zhouyuApplicationContext.getBean("userService");
        userServiceImplTest.test();     // 1. 代理对象  2. 业务test

    }
}
