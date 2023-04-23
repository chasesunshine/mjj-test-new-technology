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