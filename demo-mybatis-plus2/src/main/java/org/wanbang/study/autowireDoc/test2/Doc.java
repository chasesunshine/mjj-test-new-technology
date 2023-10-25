package org.wanbang.study.autowireDoc.test2;

/**
 * SpringBoot 自动装配原理，一文掌握！｜原创
 *
 * https://zhuanlan.zhihu.com/p/594763687
 */
public class Doc {
    /**
     * 总结
     * 最后，我们再次总结一下整个自动装配的过程。
     *
     * 1. 引入 META-INF/spring.factories 配置文件，在 EnableAutoConfiguration 对应的 value 中配置需要引入的配置类。
     *
     * 2. 启动类增加 @EnableAutoConfiguration 注解，@SpringBootApplication 已经自带。
     *
     * 3. @EnableAutoConfiguration 注解中通过 @Import 标注了 AutoConfigurationImportSelector 类。
     *
     * 4. AutoConfigurationImportSelector 继承了 DeferredImportSelector 接口，在 Spring 生命周期处理 BeanFactoryPostProcessors 的时候会对配置信息进行后置处理，这是会调用到 AutoConfigurationImportSelector.process 方法。
     *
     * 5. process 方法中会读取 META-INF/spring.factories 配置文件中的内容为 Key-Value 形式，读取完后值返回 key = EnableAutoConfiguration 对应的配置类信息，保存到 autoConfigurationEntries 中。
     *
     * 6. AutoConfigurationGroup.selectImports 方法返回排序、筛选后的配置类信息，然后依次遍历，递归调用 processImports， 根据这些配置类的全路径名读取并注册在 Spring 容器中。
     *
     */
}
