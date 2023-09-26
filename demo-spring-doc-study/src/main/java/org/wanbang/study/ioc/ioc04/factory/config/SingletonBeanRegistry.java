package org.wanbang.study.ioc.ioc04.factory.config;
/**
* @description: 这个类比较简单主要是定义了一个获取单例对象的接口
* @author majiajian
* @date 2022/9/7 18:15
* @version 1.0
*/

public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

}
