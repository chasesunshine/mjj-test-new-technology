package org.wanbang.study.ioc.ioc10.context;

import org.wanbang.study.ioc.ioc10.exception.BeansException;
import org.wanbang.study.ioc.ioc10.factory.Aware;

/**
* @description: 定义标记接口
* @author majiajian
* @date 2022/10/26 16:42
* @version 1.0
*/

/**
 *  Interface to be implemented by any object that wishes to be notifiedof the {@linkApplicationContext} that it runs in.
 *  实现此接口，既能感知到所属的 ApplicationContext
 */
public interface ApplicationContextAware extends Aware {
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
