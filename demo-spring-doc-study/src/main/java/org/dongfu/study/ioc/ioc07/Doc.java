package org.dongfu.study.ioc.ioc07;
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
    /**
     *
     *  本文主要新增了 Spring 框架中两个非常重要的接口 BeanFactoryPostProcess、
     *  BeanPostProcessor 同时还添加了关于应用上下文的实现，ApplicationContext 接
     *  口的定义是继承 BeanFactory 外新增加功能的接口，它可以满足于自动识别、资
     *  源加载、容器事件、监听器等功能，同时例如一些国际化支持、单例 Bean 自动初
     *  始化等，也是可以在这个类里实现和扩充的。
     *  通过本文的实现一定会非常了解 BeanFactoryPostProcess、BeanPostProcessor，以
     *  后再做一些关于 Spring 中间件的开发时，如果需要用到 Bean 对象的获取以及修
     *  改一些属性信息，那么就可以使用这两个接口了。同时 BeanPostProcessor 也是
     *  实现 AOP 切面技术的关键所在。
     *
     */
}
