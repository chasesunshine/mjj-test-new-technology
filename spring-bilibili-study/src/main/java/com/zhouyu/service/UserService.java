package com.zhouyu.service;

import com.spring.Autowired;
import com.spring.Component;
import com.spring.Scope;
import org.springframework.core.annotation.Order;

@Component(value = "userService")
@Scope("prototype")
// singleton
public class UserService {

    @Autowired
    private OrderService orderService;

    public void test(){
        System.out.println(orderService);
    }
}
