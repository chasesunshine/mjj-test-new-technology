package org.wanbang.study.allDesignMode.constructMode.appearanceMode.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @description: TODO
 * @author majiajian
 * @date 2022/8/12 19:25
 * @version 1.0
 */

@Configuration
//@ConditionalOnClass(StarterService.class)
//@EnableConfigurationProperties(StarterServiceProperties.class)
public class StarterAutoConfigure {
    @Autowired
    private StarterServiceProperties properties;

//    @Bean
//    @ConditionalOnMissingBean
//    @ConditionalOnProperty(prefix = "itstack.door", value = "enabled", havingValue = "true")
//    StarterService starterService() {
//        System.out.println(properties.getUserStr());
//        StarterService setvalue = new StarterService().setvalue(properties.getUserStr());
//        return setvalue;
//    }

}
