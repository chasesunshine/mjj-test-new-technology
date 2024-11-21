package org.wanbang.study.ConditionAnno.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;
import org.wanbang.study.ConditionAnno.entity.User;
import org.wanbang.study.ConditionAnno.condition.Person;

@Component
public class AutoConfig {

    //如果条件为true则创建bean，否则忽略bean
    @Conditional(value = Person.class)
    //bean别名pi
    @Bean(name = "pi")
    public User user(){
        return new User("dan",3);
    }
}

