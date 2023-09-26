package org.wanbang;


import com.alibaba.fastjson.JSON;
import org.wanbang.config.TestProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)	//注意测试文件的位置 必须在主文件加载包路径下
@SpringBootTest
public class TestConfigration {
    @Resource
    private TestProperties TestProperties;

    /**
     * 令牌的获取
     */
    @Test
    public void contextLoads() {
        System.out.println("test");
        System.out.println(JSON.toJSONString(TestProperties));
    }
}
