package org.wanbang.study.beanPostProcessorBeforeAndAfter;

/**
 * https://blog.csdn.net/fox9916/article/details/128917992
 */
public class Doc {
    /**
     * 结论：从单元测试的执行结果来看，验证了Spring的扩展点BeanPostProcessor的执行时机，即postProcessBeforeInitialization方法的执行时机是在Spring管理的Bean实例化、属性注入完成后，
     * InitializingBean#afterPropertiesSet方法以及自定义的初始化方法之前；
     * postProcessAfterInitialization方法的执行时机是在InitializingBean#afterPropertiesSet方法以及自定义的初始化方法之前之后；
     *
     */
}
