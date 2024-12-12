package org.wanbang.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.wanbang.util.JasyptUtil;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {
    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Bean
    public DataSource dataSource(){
        String decrypt = JasyptUtil.decrypt(password);
        return DataSourceBuilder.create().url(url).username(username).password(decrypt).build();
    }
}
