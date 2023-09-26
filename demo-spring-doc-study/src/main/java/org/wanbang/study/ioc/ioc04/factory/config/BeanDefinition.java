package org.wanbang.study.ioc.ioc04.factory.config;

import lombok.Data;

/**
* @description: BeanDefinition
* @author majiajian
* @date 2022/9/7 18:15
* @version 1.0
*/

/**
 * 在 Bean 定义类中已经把上一章节中的 Object bean 替换为 Class，这样就可以把
 * Bean 的实例化操作放到容器中处理了。如果你有仔细阅读过上一章并做了相应的
 * 测试，那么你会发现 Bean 的实例化操作是放在初始化调用阶段传递给
 * BeanDefinition 构造函数的
 */
@Data
public class BeanDefinition {
    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

}
