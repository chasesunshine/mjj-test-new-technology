package org.wanbang.study.ioc.ioc10.core.io;
/**
* @description: TODO
* @author majiajian
* @date 2022/10/8 11:13
* @version 1.0
*/

/**
 * 定义获取资源接口，里面传递 location 地址即可。
 */
public interface ResourceLoader {

    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);

}
