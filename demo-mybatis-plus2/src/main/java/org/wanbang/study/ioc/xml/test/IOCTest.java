package org.wanbang.study.ioc.xml.test;

import org.wanbang.study.ioc.xml.ExtClassPathXmlApplicationContext;
import org.wanbang.study.ioc.xml.OrderService;

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