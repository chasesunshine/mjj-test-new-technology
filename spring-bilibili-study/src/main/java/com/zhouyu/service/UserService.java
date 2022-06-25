package com.zhouyu.service;

import com.spring.Autowired;
import com.spring.BeanNameAware;
import com.spring.Component;
import com.spring.Scope;
import org.springframework.core.annotation.Order;

@Component(value = "userService")
@Scope("prototype")
// singleton
public class UserService implements BeanNameAware {

    @Autowired
    private OrderService orderService;

    private String beanName;

    @Override
    public void setBeanName(String name) {
        beanName = name;
    }

    public void test(){
        System.out.println(orderService);
        System.out.println(beanName);
    }

}
