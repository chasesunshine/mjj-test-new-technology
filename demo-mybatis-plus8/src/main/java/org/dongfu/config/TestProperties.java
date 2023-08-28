package org.dongfu.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author 言曌
 * @date 2020/9/17 2:51 下午
 */
@Configuration
@ConfigurationProperties(prefix = "test")
public class TestProperties {

    private String namesrvAddr;
    private String group;

    public String getNamesrvAddr() {
        return namesrvAddr;
    }

    public void setNamesrvAddr(String namesrvAddr) {
        this.namesrvAddr = namesrvAddr;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
