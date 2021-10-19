package org.wanbang.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.wanbang.entity.User;

@Configuration
public class BeanConfig {

    @Value("${user.id}")
    private Integer id;

    @Value("${user.name}")
    private String name;

    @Value("${user.age}")
    private Integer age;

    @Value("${user.sex}")
    private String sex;

    private static Integer ID;
    private static String NAME;
    private static Integer AGE;
    private static String SEX;


    @Bean
    public void transferService() {
        ID = id ;
        NAME = name;
        AGE = age;
        SEX = sex;

    }

    public static User getUser(){
        return new User().setId(ID).setName(NAME).setAge(AGE).setSex(SEX);
    }
}
