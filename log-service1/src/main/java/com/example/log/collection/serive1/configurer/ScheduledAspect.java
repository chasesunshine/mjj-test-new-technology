package com.example.log.collection.serive1.configurer;

import com.log.collection.core.LogCollectionConstants;
import com.log.collection.core.LogHelper;
import freemarker.template.utility.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

/**
 * @author :XXX
 * @date :2021-02-08 11:32
 * @description :
 */
@Aspect
@Component
@Slf4j
public class ScheduledAspect {

    @Pointcut("@annotation(org.springframework.scheduling.annotation.Scheduled)")
    public void proxyAspect() {
    }

    @Before("proxyAspect()")
    public void before(JoinPoint joinPoint) throws Throwable {
        String traceId= LogHelper.getTraceId();
        MDC.put(LogCollectionConstants.traceId, traceId);
    }
}