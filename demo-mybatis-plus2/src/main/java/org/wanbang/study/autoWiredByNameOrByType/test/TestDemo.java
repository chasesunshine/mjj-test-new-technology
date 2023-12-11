package org.wanbang.study.autoWiredByNameOrByType.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {
    @Test
    public void test1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        UserService service = (UserService)ctx.getBean("userService");
        System.out.println(service.getUserDAO());
        //打印出来是1 说明默认注入的是UserDAO
    }

    @Test
    public void test2(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans1.xml");
        UserService service = (UserService)ctx.getBean("userService");
        System.out.println(service.getUserDAO());
        //打印出来是1 说明默认注入的是UserDAO
    }
}
