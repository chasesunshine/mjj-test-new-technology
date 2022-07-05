package com.zhouyu.service;

import com.spring.BeanPostProcessor;
import com.spring.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
//        if(beanName.equals("userService")){
//            System.out.println("初始化前");
//            ((UserServiceImpl)bean).setName("mjj好帅");
//        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("初始化后");

        if(beanName.equals("userService")){
            Object instance = Proxy.newProxyInstance(ZhouyuBeanPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("代理逻辑");  //找切点
                    return method.invoke(bean,args);
                }
            });
            return instance;
        }

        return bean;
    }
}
