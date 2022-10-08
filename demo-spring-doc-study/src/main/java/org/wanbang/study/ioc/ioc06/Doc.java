package org.wanbang.study.ioc.ioc06;
/**
* @description: TODO
* @author majiajian
* @date 2022/9/7 18:18
* @version 1.0
*/

/**
 *
 * 依照本章节的需求背景，我们需要在现有的 Spring 框架雏形中添加一个资源
 * 解析器，也就是能读取 classpath、本地文件和云文件的配置内容。这些配置
 * 内容就是像使用 Spring 时配置的 Spring.xml 一样，里面会包括 Bean 对象
 * 的描述和属性信息。 在读取配置文件信息后，接下来就是对配置文件中的
 * Bean 描述信息解析后进行注册操作，把 Bean 对象注册到 Spring 容器中。
 *
 */

/**
 *
 *  资源加载器属于相对独立的部分，它位于 Spring 框架核心包下的 IO 实现内容，
 * 主要用于处理 Class、本地和云环境中的文件信息。
 *  当资源可以加载后，接下来就是解析和注册 Bean 到 Spring 中的操作，这部分实
 * 现需要和 DefaultListableBeanFactory 核心类结合起来，因为你所有的解析后的注
 * 册动作，都会把 Bean 定义信息放入到这个类中。
 *  那么在实现的时候就设计好接口的实现层级关系，包括我们需要定义出 Bean 定义
 * 的读取接口 BeanDefinitionReader 以及做好对应的实现类，在实现类中完
 * 成对 Bean 对象的解析和注册。
 *
 */

/**
 *
 *  本章节为了能把 Bean 的定义、注册和初始化交给 Spring.xml 配置化处理，那么
 * 就需要实现两大块内容，分别是：资源加载器、xml 资源处理类，实现过程主要以
 * 对接口 Resource、ResourceLoader 的实现，而另外
 * BeanDefinitionReader 接口则是对资源的具体使用，将配置信息注册到
 * Spring 容器中去。
 *  在 Resource 的资源加载器的实现中包括了，ClassPath、系统文件、云配置文件，
 * 这三部分与 Spring 源码中的设计和实现保持一致，最终在
 * DefaultResourceLoader 中做具体的调用。
 *  接口：BeanDefinitionReader、抽象类：AbstractBeanDefinitionReader、实现类：
 * XmlBeanDefinitionReader，这三部分内容主要是合理清晰的处理了资源读取后的注
 * 册 Bean 容器操作。接口管定义，抽象类处理非接口功能外的注册 Bean 组件填
 * 充，最终实现类即可只关心具体的业务实
 *
 */

/**
 *
 *  BeanFactory，已经存在的 Bean 工厂接口用于获取 Bean 对象，这次新增加了按
 * 照类型获取 Bean 的方法：<T> T getBean(String name, Class<T>
 * requiredType)
 *  ListableBeanFactory，是一个扩展 Bean 工厂接口的接口，新增加了
 * getBeansOfType、getBeanDefinitionNames() 方法，在 Spring 源码
 * 中还有其他扩展方法。
 *  HierarchicalBeanFactory，在 Spring 源码中它提供了可以获取父类 BeanFactory
 * 方法，属于是一种扩展工厂的层次子接口。Sub-interface implemented by bean
 * factories that can be part of a hierarchy.
 *  AutowireCapableBeanFactory，是一个自动化处理 Bean 工厂配置的接口，目前案
 * 例工程中还没有做相应的实现，后续逐步完善。
 *  ConfigurableBeanFactory，可获取 BeanPostProcessor、BeanClassLoader 等的一个
 * 配置化接口。
 *  ConfigurableListableBeanFactory，提供分析和修改 Bean 以及预先实例化的操作接
 * 口，不过目前只有一个 getBeanDefinition 方法。
 *
 */
public class Doc {

}
