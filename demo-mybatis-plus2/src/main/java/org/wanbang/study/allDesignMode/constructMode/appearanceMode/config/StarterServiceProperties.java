package org.wanbang.study.allDesignMode.constructMode.appearanceMode.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @description: TODO
 * @author majiajian
 * @date 2022/8/12 19:25
 * @version 1.0
 */

@Getter
@Setter
public class StarterServiceProperties {
    private String userStr;
}
