package wanbang;


import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wanbang.dao.TestDataDao;
import org.wanbang.entity.TestData;

import javax.annotation.Resource;

@SpringBootConfiguration
@RunWith(SpringRunner.class)	//注意测试文件的位置 必须在主文件加载包路径下
@SpringBootTest
public class TestTDEngine {
    @Resource
    private TestDataDao testDao;

    /**
     * 令牌的获取
     */
    @Test
    public void contextLoads() {
        TestData test = testDao.selectData();
        System.out.println(JSON.toJSONString(test));
    }
}
