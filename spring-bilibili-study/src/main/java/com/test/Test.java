package com.test;

import com.spring.ZhouyuApplicationContext;
import com.zhouyu.AppConfig;

public class Test {
    public static void main(String[] args) {
        ZhouyuApplicationContext zhouyuApplicationContext = new ZhouyuApplicationContext(AppConfig.class);

        Object userService = zhouyuApplicationContext.getBean("userService");  // map<beanName,bean对象>

        System.out.println(userService);
    }
}
