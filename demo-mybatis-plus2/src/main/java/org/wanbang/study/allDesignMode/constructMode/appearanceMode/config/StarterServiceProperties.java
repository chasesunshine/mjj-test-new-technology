package org.wanbang.study.allDesignMode.constructMode.appearanceMode.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @description: TODO
 * @author majiajian
 * @date 2022/8/12 19:25
 * @version 1.0
 */

@ConfigurationProperties("itstack.door")
public class StarterServiceProperties {
    private String userStr;
    public String getUserStr() {
        return userStr;
    }

    public void setUserStr(String userStr) {
        this.userStr = userStr;
    }
}
