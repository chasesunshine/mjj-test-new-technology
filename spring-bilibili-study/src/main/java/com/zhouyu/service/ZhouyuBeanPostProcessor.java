package com.zhouyu.service;

import com.spring.BeanPostProcessor;
import com.spring.Component;

/**
* @description: TODO
* @author majiajian
* @date 2022/7/1 17:58
* @version 1.0
*/

@Component
public class ZhouyuBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if(beanName.equals("userService")){
            System.out.println("初始化前");
            ((UserService)bean).setName("mjj好帅");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("初始化后");
        return bean;
    }
}
