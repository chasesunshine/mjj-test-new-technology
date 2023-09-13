package org.dongfu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)	//注意测试文件的位置 必须在主文件加载包路径下
@SpringBootTest
public class TestRedis {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;


    //存储对象
    @Test
    public void testRedis(){
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ops.set("xiaoming","xiaoming");
    }


    @Test
    public void testRedis1(){
        String value = redisTemplate.opsForValue().get("xiaoming");
        System.out.println(value);

    }

}
