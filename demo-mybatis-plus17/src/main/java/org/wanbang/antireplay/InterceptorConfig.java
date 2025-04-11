package org.wanbang.antireplay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 我们在配置类上添加了注解@Configuration，标明了该类是一个配置类并且会将该类作为一个SpringBean添加到IOC容器内
 * 将以下代码写在InterceptorConfig.java中 ，使用addInterceptors方法将我们定义的拦截器添加进入项目中
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Value("${access.key.property}") // 从配置文件中读取key
    private String accessKey;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SignAuthInterceptor(redisTemplate,accessKey))
                .addPathPatterns("/**"); // 拦截所有路径
    }
}
