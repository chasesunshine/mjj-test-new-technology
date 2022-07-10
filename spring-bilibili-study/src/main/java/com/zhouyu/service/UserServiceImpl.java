package com.zhouyu.service;

import com.spring.*;
import org.apache.catalina.User;

@Component(value = "userService")
@Scope("prototype")
// singleton
public class UserServiceImpl implements UserService,BeanNameAware, InitializingBean {

    @Autowired
    private OrderService orderService;

    private String name;

    private String beanName;

    private User defaultUser;

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
        // 因为 defaultUser上 没有@Autowired,但是我想要初始化之后有值
        // 所以需要 userService 继承 InitializingBean 在这里对其进行处理与赋值
        // mysql 中拿到数据 赋值 --> defaultUser
    }

    @Override
    public void test(){
        System.out.println(orderService);
        System.out.println(beanName);
    }

}
