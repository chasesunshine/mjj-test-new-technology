package org.wanbang.study.ioc.ioc07;
/**
* @description: TODO
* @author majiajian
* @date 2022/9/7 18:18
* @version 1.0
*/

/**
 *
 *  在整个类图中主要体现出来的是关于 Spring 应用上下文以及对 Bean 对象扩展机
 * 制的实现。
 *  以继承了 ListableBeanFactory 接口的 ApplicationContext 接口开始，扩展出一系
 * 列应用上下文的抽象实现类，并最终完成
 * ClassPathXmlApplicationContext 类的实现。而这个类就是最后交给用
 * 户使用的类。
 *  同时在实现应用上下文的过程中，通过定义接口：
 * BeanFactoryPostProcessor、BeanPostProcessor 两个接口，把关于
 * 对 Bean 的扩展机制串联进去了。
 *
 */
public class Doc {

}
