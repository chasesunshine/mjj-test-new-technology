package org.wanbang.study.xml.test;

import org.wanbang.study.xml.ExtClassPathXmlApplicationContext;
import org.wanbang.study.xml.OrderService;

// https://blog.csdn.net/yz2015/article/details/80556694
/**
 * 测试ioc代码
 * Created by yz on 2018/6/3.
 */
public class IOCTest {
    public static void main(String[] args) throws Exception {
        ExtClassPathXmlApplicationContext context = new ExtClassPathXmlApplicationContext("spring.xml");
        OrderService orderService = (OrderService) context.getBean("orderService");
        orderService.addOrder();
    }
}