package org.wanbang.study.ioc.ioc03;
/**
* @description: TODO
* @author majiajian
* @date 2022/9/7 18:18
* @version 1.0
*/

public class Doc {
//    1. BeanFactory 的定义由 AbstractBeanFactory 抽象类实现接口的 getBean 方法
//    2. 而 AbstractBeanFactory 又继承了实现了 SingletonBeanRegistry 的DefaultSingletonBeanRegistry类。
//       这样 AbstractBeanFactory 抽象类就具备了单例
//       Bean 的注册功能。
//    3. AbstractBeanFactory 中又定义了两个抽象方法：getBeanDefinition(String beanName)、
//       createBean(String beanName, BeanDefinition beanDefinition) ，而这
//       两个抽象方法分别由 DefaultListableBeanFactory、
//       AbstractAutowireCapableBeanFactory 实现。
//    4. 最终 DefaultListableBeanFactory 还会继承抽象类
//       AbstractAutowireCapableBeanFactory 也就可以调用抽象类中的 createBean 方法了。

}
