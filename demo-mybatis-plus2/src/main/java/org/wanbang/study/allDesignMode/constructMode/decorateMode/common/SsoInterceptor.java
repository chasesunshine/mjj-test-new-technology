package org.wanbang.study.allDesignMode.constructMode.decorateMode.common;
/**
* @description: TODO
* @author majiajian
* @date 2022/8/12 16:49
* @version 1.0
*/

public class SsoInterceptor implements HandlerInterceptor{
    public boolean preHandle(String request, String response, Object handler) {
        // 模拟获取cookie
        String ticket = request.substring(1, 8);
        // 模拟校验
        return ticket.equals("success");
    }
}
