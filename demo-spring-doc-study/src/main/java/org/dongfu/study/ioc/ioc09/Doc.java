package org.dongfu.study.ioc.ioc09;
/**
* @description: TODO
* @author majiajian
* @date 2022/10/10 13:56
* @version 1.0
*/

/**
 *  定义接口 Aware，在 Spring 框架中它是一种感知标记性接口，具体的子类定义和
 * 实现能感知容器中的相关对象。也就是通过这个桥梁，向具体的实现类中提供容器
 * 服务
 *  继承 Aware 的接口包括：BeanFactoryAware、BeanClassLoaderAware、
 * BeanNameAware 和 ApplicationContextAware，当然在 Spring 源码中还有一些其
 * 他关于注解的，不过目前我们还是用不到。
 *  在具体的接口实现过程中你可以看到，一部分(BeanFactoryAware、
 * BeanClassLoaderAware、BeanNameAware)在 factory 的 support 文件夹下，另外
 * ApplicationContextAware 是在 context 的 support 中，这是因为不同的内容获取
 * 需要在不同的包下提供。所以，在 AbstractApplicationContext 的具体实现中会用
 * 到向 beanFactory 添加 BeanPostProcessor 内容的
 * ApplicationContextAwareProcessor 操作，最后由
 * AbstractAutowireCapableBeanFactory 创建 createBean 时处理相应的调用操作。
 * 关于 applyBeanPostProcessorsBeforeInitialization 已经在前面章节中实现过，如果
 * 忘记可以往前翻翻
 */
public class Doc {
    /**
     *  测试方法中主要是添加了一写关于新增 Aware 实现的调用，其他不需要调用的也
     * 打印了相应的日志信息，可以在测试结果中看到。
     */


    /**
     *  目前关于 Spring 框架的实现中，某些功能点已经越来趋向于完整，尤
     * 其是 Bean 对象的生命周期，已经有了很多的体现。整体总结如图 9-3
     *
     *  本章节关于 Aware 的感知接口的四个继承接口 BeanNameAware,
     * BeanClassLoaderAware, ApplicationContextAware, BeanFactoryAware
     * 的实现，又扩展了 Spring 的功能。如果你有做过关于 Spring 中间件
     * 的开发那么一定会大量用到这些类，现在你不只是用过，而且还知道他
     * 们都是什么时候触达的，在以后想排查类的实例化顺序也可以有一个清
     * 晰的思路了。
     *
     *  每一章节内容的实现都是在以设计模式为核心的结构上填充各项模块的
     * 功能，单纯的操作编写代码并不会有太多收获，一定是要理解为什么这
     * 么设计，这么设计的好处是什么，怎么就那么多接口和抽象类的应用，
     * 这些才是 Spring 框架学习的核心所在。
     */
}
