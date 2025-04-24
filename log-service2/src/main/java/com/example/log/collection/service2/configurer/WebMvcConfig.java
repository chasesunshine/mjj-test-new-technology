package com.example.log.collection.service2.configurer;

import com.log.collection.core.TraceInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author :XXX
 * @date :2021-02-07 17:52
 * @description :
 */
@Configuration
@Slf4j
public class WebMvcConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        log.info("log-service2 注册过滤器 ，将上游请求中traceId值取出。使用MDC类将内容记录到日志中");
        registry.addInterceptor(new TraceInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
