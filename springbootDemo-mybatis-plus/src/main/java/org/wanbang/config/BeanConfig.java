package org.wanbang.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.wanbang.entity.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Bean("redisStringTemplate")
    public RedisTemplate<Object, Object> redisStringTemplate(RedisConnectionFactory factory) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        return redisTemplate;
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");

        String s = strings.toArray().toString();
        System.out.println(s);
    }

}
