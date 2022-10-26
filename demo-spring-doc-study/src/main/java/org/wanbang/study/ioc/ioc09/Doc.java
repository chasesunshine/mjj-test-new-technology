package org.wanbang.study.ioc.ioc09;
/**
* @description: TODO
* @author majiajian
* @date 2022/10/10 13:56
* @version 1.0
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
