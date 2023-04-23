package com.log.collection.core;

import org.slf4j.MDC;

/**
 * @author :XXX
 * @date :2020-12-18 18:09
 * @description :
 */
public class LogFeignInterceptorConfig {

    public String getTraceId() {
        return MDC.get(LogCollectionConstants.traceId);
    }
}