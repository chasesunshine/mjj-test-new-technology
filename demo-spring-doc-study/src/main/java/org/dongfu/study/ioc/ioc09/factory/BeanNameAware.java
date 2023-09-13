package org.dongfu.study.ioc.ioc09.factory;
/**
* @description: 容器感知类
* @author majiajian
* @date 2022/10/26 16:33
* @version 1.0
*/

/**
 *  Interface to be implemented by beans that want to be aware of their bean name in
 * a bean factory.
 *  实现此接口，既能感知到所属的 BeanName
 */
public interface BeanNameAware extends Aware {
    void setBeanName(String name);
}
