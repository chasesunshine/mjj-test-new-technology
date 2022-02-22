package org.wanbang.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.wanbang.config.properties.AuthProperties;
import org.wanbang.config.properties.TemplateProperties;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 服务模块通用配置
 *
 * @author xiongmw@wbpharma.com
 * @version 1.0
 */
@Slf4j
@Configuration
@Data
public class SpringConfig {

    /**
     * 模板文件URL
     */
    @Bean
    @ConfigurationProperties("template")
    public TemplateProperties templateProperties() {
        return new TemplateProperties();
    }

    @Bean
    @ConfigurationProperties("auth")
    public AuthProperties authProperties() {
        return new AuthProperties();
    }

}
