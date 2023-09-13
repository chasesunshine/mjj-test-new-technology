package org.dongfu.study.allDesignMode.constructMode.decorateMode.common;
/**
* @description: TODO
* @author majiajian
* @date 2022/8/12 16:49
* @version 1.0
*/

public interface HandlerInterceptor {
    boolean preHandle(String request, String response, Object handler);
}
