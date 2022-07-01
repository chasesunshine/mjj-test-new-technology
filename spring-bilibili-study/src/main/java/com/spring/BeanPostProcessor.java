package com.spring;

import org.springframework.beans.BeansException;
import org.springframework.lang.Nullable;

/**
* @description: TODO
* @author majiajian
* @date 2022/7/1 17:55
* @version 1.0
*/

public interface BeanPostProcessor {

    Object postProcessBeforeInitialization(Object bean, String beanName);

    Object postProcessAfterInitialization(Object bean, String beanName);
}
