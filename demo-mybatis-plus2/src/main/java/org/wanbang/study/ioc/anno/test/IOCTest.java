package org.wanbang.study.ioc.anno.test;

import org.wanbang.study.ioc.anno.ExtClassPathXmlApplicationContext;
import org.wanbang.study.ioc.anno.UserService;

// https://blog.csdn.net/yz2015/article/details/80556694
/**
 * Created by yz on 2018/6/3.
 */
public class IOCTest {
    public static void main(String[] args) throws Exception {
        ExtClassPathXmlApplicationContext context = new ExtClassPathXmlApplicationContext("spring.xml");
//        OrderService orderService = (OrderService) context.getBean("orderServiceImpl");
//        orderService.addOrder();
        UserService userService = (UserService) context.getBean("userServiceImpl");
        userService.add();
    }
}