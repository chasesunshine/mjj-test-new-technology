package org.dongfu.study.filterAndInterceptor.paramFilter;

import org.slf4j.MDC;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.dongfu.common.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * @author cloudgc
 * @since 10/12/2020
 */
@ControllerAdvice("org.wanbang")
public class ResponseAdvisor implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
                                  ServerHttpResponse response) {
        HttpServletRequest request1 = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String traceId1 = (String) request1.getAttribute("traceId");


        String traceId = MDC.get("traceId");
        if(body instanceof Result){
            ((Result) body).setTraceId(traceId);
        }

        return body;
    }

    private String getReturnName(MethodParameter returnType) {
        return returnType.getMethod().getReturnType().getName();

    }

    private boolean isBasicType(MethodParameter returnType) {

        if (returnType == null || returnType.getMethod() == null) {
            return true;
        }

        String name = returnType.getMethod().getReturnType().getSimpleName();
        switch (name) {
            case "String":
            case "byte[]":
            case "ResponseEntity":
                return true;
            default:
                return false;
        }

    }


}
