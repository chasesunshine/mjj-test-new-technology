package org.wanbang;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ThreadPoolExecutor;

@RunWith(SpringRunner.class)	//注意测试文件的位置 必须在主文件加载包路径下
@SpringBootTest
public class TestMjj {
    @Autowired
    private ThreadPoolExecutor myThreadPool;

    @Test
    public void test1(){
        System.out.println("CoolPoolSize=" + myThreadPool.getCorePoolSize());
    }
}
