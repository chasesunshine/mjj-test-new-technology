package org.wanbang.study.ioc.ioc03.factory.config;

import lombok.Data;

/**
* @description: TODO
* @author majiajian
* @date 2022/9/7 18:15
* @version 1.0
*/

@Data
public class BeanDefinition {
    private Class beanClass;
    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }
// ...get/set
}
