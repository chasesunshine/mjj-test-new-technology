package org.dongfu.util.redis;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RedisUtils{
    @Resource
    private SpringContextHolder springContextHolder;

    public void set(String key,String value){
        StringRedisTemplate bean = springContextHolder.getBean(StringRedisTemplate.class);
        bean.opsForValue().set(key,value);
    }
}
