package org.wanbang.study.filterAndInterceptor.paramFilter;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.wanbang.common.entity.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cloudgc
 * @since 10/12/2020
 */
@ControllerAdvice("com.fosunhealth.scm")
public class ResponseAdvisor implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
                                  ServerHttpResponse response) {

        ServletServerHttpResponse responseTemp = (ServletServerHttpResponse) response;
        HttpServletResponse resp = responseTemp.getServletResponse();
        ServletServerHttpRequest sshr = (ServletServerHttpRequest) request;
        HttpServletRequest req = sshr.getServletRequest();
        String traceId = (String)req.getAttribute("traceId");
        //此处的 Result 对象是我自定义的返回值类型,具体根据自己需求修改即可
        if(body instanceof Result){
            Result result = (Result) body;
            if(result!=null) {
                result.setTraceId("1222");
                //记录日志等操作
            }
            //这里可以对返回值进行修改二次封装等操作
        }
        return body;

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
