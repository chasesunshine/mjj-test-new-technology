package com.example.log.collection.serive1.configurer;

import com.log.collection.core.LogCollectionConstants;
import com.log.collection.core.LogFeignInterceptorConfig;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

/**
 * @author :XXX
 * @date :2021-02-07 17:50
 * @description :
 */
@Configuration
public class FeignInterceptorConfig extends LogFeignInterceptorConfig implements RequestInterceptor {

    /**
     * 个人理解 ： 这是feign 接口透传
     * @param requestTemplate
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header(LogCollectionConstants.traceId, super.getTraceId());
        System.out.println("log-service1 FeignInterceptorConfig");
    }
}
