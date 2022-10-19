package org.wanbang.study;
/**
* @description: TODO
* @author majiajian
* @date 2022/9/2 15:38
* @version 1.0
*/

public class Doc {
    /**
     *  本文主要完成了关于初始和销毁在使用接口定义 implements
     * InitializingBean, DisposableBean 和在 spring.xml 中配置 initmethod="initDataMethod" destroymethod="destroyDataMethod" 的两种具体在
     * AbstractAutowireCapableBeanFactory 完成初始方法和
     * AbstractApplicationContext 处理销毁动作的具体实现过程。
     *  通过本文的实现内容，可以看到目前这个 Spring 框架对 Bean 的操作越来越完善
     * 了，可扩展性也不断的增强。你既可以在 Bean 注册完成实例化前进行
     * BeanFactoryPostProcessor 操作，也可以在 Bean 实例化过程中执行前置和后置操
     * 作，现在又可以执行 Bean 的初始化方法和销毁方法。所以一个简单的 Bean 对
     * 象，已经被赋予了各种扩展能力。
     *  在学习和动手实践 Spring 框架学习的过程中，特别要注意的是它对接口和抽象类
     * 的把握和使用，尤其遇到类似，A 继承 B 实现 C 时，C 的接口方法由 A 继承的父类
     * B 实现，这样的操作都蛮有意思的。也是可以复用到通常的业务系统开发中进行处
     * 理一些复杂逻辑的功能分层，做到程序的可扩展、易维护等特性。
     */
}
