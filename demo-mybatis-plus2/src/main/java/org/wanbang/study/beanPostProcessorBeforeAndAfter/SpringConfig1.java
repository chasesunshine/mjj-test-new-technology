package org.wanbang.study.beanPostProcessorBeforeAndAfter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig1 {
    @Bean(initMethod = "init")
    public Dog1 dog(){
        Dog1 dog = new Dog1();
        return dog;
    }
}

