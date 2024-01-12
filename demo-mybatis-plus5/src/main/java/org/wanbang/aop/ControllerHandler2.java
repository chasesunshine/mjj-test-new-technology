package org.wanbang.aop;
/**
* @description: TODO
* @author majiajian
* @date 2023/4/23 11:33
* @version 1.0
*/

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.wanbang.dto.response.ResponseCode;
import org.wanbang.dto.response.ResponseData;
import org.wanbang.exception.DemoRuntimeException;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

@Component
@Slf4j
@Aspect
@Order(1)
public class ControllerHandler2 {

    private final static String TRACE_ID = "TRACE_ID";

    @Autowired
    HttpServletRequest request;

    @Pointcut("execution(public * org.wanbang.controller..*.*(..)) ")
    public void recordLog() {

    }

    public void setTraceId(){
        if (request != null && request.getHeader("Trace-Id") != null) {
            MDC.put(TRACE_ID, request.getHeader("Trace-Id"));
        }else{
            MDC.put(TRACE_ID, UUID.randomUUID().toString());
        }
    }

    @SneakyThrows
    @Around("recordLog()")
    public Object record(ProceedingJoinPoint joinPoint) {
        Object response;
        try {
            response = joinPoint.proceed(joinPoint.getArgs());
        } catch (Exception e) {
            System.out.println("测试2");
            throw new RuntimeException(e);
        }
        return response + "222222";
    }

}
