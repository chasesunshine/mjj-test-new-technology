package org.wanbang.study.ioc.step01;

import org.wanbang.study.ioc.step01.springframework.BeanDefinition;
import org.wanbang.study.ioc.step01.springframework.BeanFactory;
import org.wanbang.study.ioc.step01.springframework.bean.UserService;

/**
* @description: TODO
* @author majiajian
* @date 2022/9/2 15:49
* @version 1.0
*/

public class Test {

    public static void main(String[] args) {
        // 1.初始化 BeanFactory
        BeanFactory beanFactory = new BeanFactory();
        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 3.获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

}
