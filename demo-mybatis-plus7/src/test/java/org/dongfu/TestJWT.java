package org.dongfu;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.HashMap;

@RunWith(SpringRunner.class)	//注意测试文件的位置 必须在主文件加载包路径下
@SpringBootTest
public class TestJWT {

    /**
     * 令牌的获取
     */
    @Test
    public void contextLoads() {
        HashMap<String, Object> map = new HashMap<>();

        //获取日历对象
        Calendar instance = Calendar.getInstance();
        //默认30S过期
        instance.add(Calendar.SECOND,30);

        String token = JWT.create()
                .withHeader(map)     //header,可以不写
                .withClaim("userId", 21)    //payload
                .withClaim("username", "Garry")   //payload
                .withExpiresAt(instance.getTime())    //设置过期时间
                .sign(Algorithm.HMAC256("!ISN!@#￥%"));   //签名

        System.out.println(token);
    }
}
