package org.dongfu.study.filterAndInterceptor.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.annotation.Resource;

// 将以下代码写在InterceptorConfig.java中 ，使用addInterceptors方法将我们定义的拦截器添加进入项目中
@Configuration
public class InterceptorConfig  implements WebMvcConfigurer {
    @Resource
    TokenInterceptor tokenInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 设置所有的路径都要进行拦截，除了/test/login
        registry.addInterceptor(tokenInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/test/login");
    }
}
