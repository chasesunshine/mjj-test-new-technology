package org.wanbang.study.ioc.ioc08.factory.config;

import org.wanbang.study.ioc.ioc08.entity.PropertyValues;

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
 *
 *  在 BeanDefinition 新增加了两个属性：initMethodName、destroyMethodName，
 * 这两个属性是为了在 spring.xml 配置的 Bean 对象中，可以配置 initmethod="initDataMethod" destroymethod="destroyDataMethod" 操作，最终实现接口的效果是一样的。只不
 * 过一个是接口方法的直接调用，另外是一个在配置文件中读取到方法反射调用
 */
public class BeanDefinition {

    private Class beanClass;

    private PropertyValues propertyValues;

    private String initMethodName;

    private String destroyMethodName;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public String getInitMethodName() {
        return initMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public String getDestroyMethodName() {
        return destroyMethodName;
    }

    public void setDestroyMethodName(String destroyMethodName) {
        this.destroyMethodName = destroyMethodName;
    }
}
