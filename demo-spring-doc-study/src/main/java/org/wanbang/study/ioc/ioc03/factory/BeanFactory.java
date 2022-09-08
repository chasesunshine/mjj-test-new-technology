package org.wanbang.study.ioc.ioc03.factory;

import org.wanbang.study.ioc.ioc03.exception.BeansException;

/**
* @description: TODO
* @author majiajian
* @date 2022/9/7 18:15
* @version 1.0
*/

public interface BeanFactory {

    Object getBean(String name) throws BeansException;

}
