package org.dongfu.study.ioc.ioc10.factory;
/**
* @description:  定义 FactoryBean 接口
* @author majiajian
* @date 2022/10/27 20:10
* @version 1.0
*/

/**
 *  FactoryBean 中需要提供 3 个方法，获取对象、对象类型，以及是否是单例对象，
 * 如果是单例对象依然会被放到内存中。
 *
 * @param <T>
 */
public interface FactoryBean<T> {
    T getObject() throws Exception;
    Class<?> getObjectType();
    boolean isSingleton();
}
