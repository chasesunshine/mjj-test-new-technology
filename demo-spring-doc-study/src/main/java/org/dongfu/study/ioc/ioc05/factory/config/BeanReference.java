package org.dongfu.study.ioc.ioc05.factory.config;

import lombok.Data;

/**
* @description: TODO
* @author majiajian
* @date 2022/9/24 16:04
* @version 1.0
*/

@Data
public class BeanReference {
    private String beanName;

    public BeanReference(String userDao) {
        this.beanName = userDao;
    }
}
