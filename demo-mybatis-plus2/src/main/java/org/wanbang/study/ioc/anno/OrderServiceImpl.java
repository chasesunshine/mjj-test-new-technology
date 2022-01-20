package org.wanbang.study.ioc.anno;

/**
 * Created by yz on 2018/6/3.
 */
@ExtService
public class OrderServiceImpl implements OrderService {
    @Override
    public void addOrder() {
        System.out.println("使用注解方式依赖注入...");
    }
}