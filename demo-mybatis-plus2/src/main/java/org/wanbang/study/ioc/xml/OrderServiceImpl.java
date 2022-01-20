package org.wanbang.study.ioc.xml;

public class OrderServiceImpl implements OrderService {
    @Override
    public void addOrder() {
        System.out.println("使用Java反射机制初始化对象...");
    }
}