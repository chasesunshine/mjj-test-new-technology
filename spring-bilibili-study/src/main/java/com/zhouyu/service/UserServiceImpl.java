package com.zhouyu.service;

import com.spring.*;

@Component(value = "userService")
@Scope("prototype")
// singleton
public class UserServiceImpl implements UserService,BeanNameAware, InitializingBean {

    @Autowired
    private OrderService orderService;

    private String name;

    private String beanName;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setBeanName(String name) {
        beanName = name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化");
    }

    @Override
    public void test(){
        System.out.println(orderService);
        System.out.println(beanName);
    }

}
