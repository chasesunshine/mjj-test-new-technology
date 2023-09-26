package org.wanbang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 我们在配置类上添加了注解@Configuration，标明了该类是一个配置类并且会将该类作为一个SpringBean添加到IOC容器内
 * 将以下代码写在InterceptorConfig.java中 ，使用addInterceptors方法将我们定义的拦截器添加进入项目中
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                .addPathPatterns("/user/test")          //拦截test接口
                .excludePathPatterns("/user/login");    //放行login接口
    }
}

