package org.dongfu.study.ioc.ioc08.test;

import org.dongfu.study.ioc.ioc08.bean.UserService;
import org.dongfu.study.ioc.ioc08.exception.BeansException;
import org.dongfu.study.ioc.ioc08.factory.config.BeanPostProcessor;

/**
* @description: TODO
* @author majiajian
* @date 2022/10/9 20:20
* @version 1.0
*/

public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("改为：北京");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

}

