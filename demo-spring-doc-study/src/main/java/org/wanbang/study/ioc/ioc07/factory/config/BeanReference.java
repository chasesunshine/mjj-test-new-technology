package org.wanbang.study.ioc.ioc07.factory.config;

import lombok.Data;

/**
* @description: TODO
* @author majiajian
* @date 2022/9/24 16:04
* @version 1.0
*/

public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

}