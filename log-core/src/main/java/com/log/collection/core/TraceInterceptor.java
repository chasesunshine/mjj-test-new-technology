package com.log.collection.core;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author :XXX
 * @date :2020-12-08 12:00
 * @description :
 */
public class TraceInterceptor implements HandlerInterceptor {

    /**
     * preHandle：在业务处理器处理请求之前被调用。预处理，可以进行编码、安全控制、权限校验等处理；
     * postHandle：在业务处理器处理请求执行完成后，生成视图之前执行。后处理（调用了Service并返回ModelAndView，但未进行页面渲染），有机会修改ModelAndView （这个博主就基本不怎么用了）；
     * afterCompletion：在DispatcherServlet完全处理完请求后被调用，可用于清理资源等。返回处理（已经渲染了页面）；
     *
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String traceIdVal = request.getHeader(LogCollectionConstants.traceId);
        if (StringUtils.isNotEmpty(traceIdVal)) {
            MDC.put(LogCollectionConstants.traceId, traceIdVal);
        }
        else {
            MDC.remove(LogCollectionConstants.traceId);
        }
        return true;
    }
}