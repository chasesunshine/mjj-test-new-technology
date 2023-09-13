package org.dongfu.study.ioc.ioc09.factory;
/**
* @description: 容器感知类
* @author majiajian
* @date 2022/10/26 16:33
* @version 1.0
*/

/**
 *  Callback that allows a bean to be aware of the bean{@link ClassLoader class loader};
 * that is, the class loader used by the present bean factory to load bean classes.
 *  实现此接口，既能感知到所属的 ClassLoader
 */
public interface BeanClassLoaderAware extends Aware{
    void setBeanClassLoader(ClassLoader classLoader);
}
