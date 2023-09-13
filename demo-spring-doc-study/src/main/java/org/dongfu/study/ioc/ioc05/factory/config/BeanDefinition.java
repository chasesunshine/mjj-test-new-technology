package org.dongfu.study.ioc.ioc05.factory.config;

import lombok.Data;
import org.dongfu.study.ioc.ioc05.entity.PropertyValues;

/**
 * @description: BeanDefinition
 * @author majiajian
 * @date 2022/9/7 18:15
 * @version 1.0
 */

/**
 *  在 Bean 注册的过程中是需要传递 Bean 的信息，在几个前面章节的测试中都有
 * 所体现 new BeanDefinition(UserService.class,
 * propertyValues);
 *  所以为了把属性一定交给 Bean 定义，所以这里填充了 PropertyValues 属性，同
 * 时把两个构造函数做了一些简单的优化，避免后面 for 循环时还得判断属性填充
 * 是否为空。
 */
@Data
public class BeanDefinition {
    private Class beanClass;

    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }
    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }
    // ...get/set

}
