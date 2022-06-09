package com.zhouyu;

import com.spring.ZhouyuApplicationContext;

public class Test {
    public static void main(String[] args) {
        ZhouyuApplicationContext zhouyuApplicationContext = new ZhouyuApplicationContext(AppConfig.class);

        Object userService = zhouyuApplicationContext.getBean("userService");
    }
}
