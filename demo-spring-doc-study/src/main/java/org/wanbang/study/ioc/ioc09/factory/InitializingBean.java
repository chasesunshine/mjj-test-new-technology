package org.wanbang.study.ioc.ioc09.factory;
/**
* @description: TODO
* @author majiajian
* @date 2022/10/10 19:24
* @version 1.0
*/

/**
 *
 *  InitializingBean、DisposableBean，两个接口方法还是比较常用的，在一些需要结
 * 合 Spring 实现的组件中，经常会使用这两个方法来做一些参数的初始化和销毁操
 * 作。比如接口暴漏、数据库数据读取、配置文件加载等等。
 *
 */
public interface InitializingBean {
    /**
     * Bean 处理了属性填充后调用
     *
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;
}
