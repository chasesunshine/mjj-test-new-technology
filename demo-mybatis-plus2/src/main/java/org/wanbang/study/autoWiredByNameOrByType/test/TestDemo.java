package org.wanbang.study.autoWiredByNameOrByType.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {

    /**
     *      这里的byName是按照属性名进行匹配 这里我们并没有注入UserDAO 但是你的UserService属性名称是UserDAO 所以就相当于 你注入了UserDAO 相当于在bean中添加
     *      <property name="userDAO" ref="userDAO"/> 一样
     */
    @Test
    public void test1_1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans_byname1.xml");
        UserService service = (UserService)ctx.getBean("userService");
        System.out.println(service.getUserDAO());
        System.out.println(service);
        //打印出来是1 说明默认注入的是UserDAO
    }
    @Test
    public void test1_2(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans_byname1.xml");
        UserService service = (UserService)ctx.getBean("userService1");
        System.out.println(service.getUserDAO());
        System.out.println(service);
        //打印出来是1 说明默认注入的是UserDAO
    }
    @Test
    public void test1_3(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans_byname1.xml");
        UserService service = (UserService)ctx.getBean("userService2");
        System.out.println(service.getUserDAO());
        System.out.println(service);
        //打印出来是1 说明默认注入的是UserDAO
    }
    @Test
    public void test1_4(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans_byname1.xml");
        UserService service = (UserService)ctx.getBean("userService3");
        System.out.println(service.getUserDAO());
        System.out.println(service);
        //打印出来是1 说明默认注入的是UserDAO
    }

    @Test
    public void test2_1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans_byname2.xml");
        UserService service = (UserService)ctx.getBean("userService");
        System.out.println(service.getUserDAO());
        System.out.println(service);
        //打印出来是1 说明默认注入的是UserDAO
    }
    @Test
    public void test2_2(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans_byname2.xml");
        UserService service = (UserService)ctx.getBean("userService1");
        System.out.println(service.getUserDAO());
        System.out.println(service);
        //打印出来是1 说明默认注入的是UserDAO
    }
    @Test
    public void test2_3(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans_byname2.xml");
        UserService service = (UserService)ctx.getBean("userService2");
        System.out.println(service.getUserDAO());
        System.out.println(service);
        //打印出来是1 说明默认注入的是UserDAO
    }
    @Test
    public void test2_4(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans_byname2.xml");
        UserService service = (UserService)ctx.getBean("userService3");
        System.out.println(service.getUserDAO());
        System.out.println(service);
        //打印出来是1 说明默认注入的是UserDAO
    }

    @Test
    public void test3_1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans_bytype1.xml");
        UserService service = (UserService)ctx.getBean("userService");
        System.out.println(service.getUserDAO());
        //打印出来是1 说明默认注入的是UserDAO
    }
    @Test
    public void test3_2(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans_bytype2.xml");
        UserService service = (UserService)ctx.getBean("userService");
        System.out.println(service.getUserDAO());
        //打印出来是1 说明默认注入的是UserDAO
    }
}
