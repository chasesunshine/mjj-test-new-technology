package org.wanbang.study.ioc.ioc05;
/**
* @description: TODO
* @author majiajian
* @date 2022/9/7 18:18
* @version 1.0
*/

/**
 *  属性填充要在类实例化创建之后，也就是需要在
 * AbstractAutowireCapableBeanFactory 的 createBean 方法中添加
 * applyPropertyValues 操作。
 *  由于我们需要在创建 Bean 时候填充属性操作，那么就需要在 bean 定义
 * BeanDefinition 类中，添加 PropertyValues 信息。
 *  另外是填充属性信息还包括了 Bean 的对象类型，也就是需要再定义一个
 * BeanReference，里面其实就是一个简单的 Bean 名称，在具体的实例化操作时进
 * 行递归创建和填充，与 Spring 源码实现一样。Spring 源码中 BeanReference 是
 * 一个接
 */
public class Doc {

    /**
     *  在本章节中我们把 AbstractAutowireCapableBeanFactory 类中的创建对象功能又
     * 做了扩充，依赖于是否有构造函数的实例化策略完成后，开始补充 Bean 属性信
     * 息。当遇到 Bean 属性为 Bean 对象时，需要递归处理。最后在属性填充时需要
     * 用到反射操作，也可以使用一些工具类处理。
     *  每一个章节的功能点我们都在循序渐进的实现，这样可以让新人更好的接受关于
     * Spring 中的设计思路。尤其是在一些已经开发好的类上，怎么扩充新的功能时候
     * 的设计更为重要。学习编程有的时候学习思路设计要比仅仅是做简单实现，更能提
     * 升编程思维。
     *  到这一章节关于 Bean 的创建操作就开发完成了，接下来需要整个框架的基础上完
     * 成资源属性的加载，就是我们需要去动 Xml 配置了，让我们这小框架越来越像
     * Spring。另外在框架实现的过程中所有的类名都会参考 Spring 源码，以及相应的
     * 设计实现步骤也是与 Spring 源码中对应，只不过会简化一些流程，但你可以拿相
     * 同的类名，去搜到每一个功能在 Spring 源码中的实现。
     */
}
