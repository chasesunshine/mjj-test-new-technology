package wanbang;


import com.alibaba.fastjson.JSON;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wanbang.dao.TemperatureDao;
import org.wanbang.dao.TestDataDao;
import org.wanbang.entity.Temperature;
import org.wanbang.entity.TestData;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Random;

@SpringBootConfiguration
@RunWith(SpringRunner.class)	//注意测试文件的位置 必须在主文件加载包路径下
@SpringBootTest
public class TestTDEngine {
    @Resource
    private TestDataDao testDao;

    private static Random random = new Random(System.currentTimeMillis());
    private static String[] locations = {"北京", "上海", "深圳", "广州", "杭州"};

    /**
     * 令牌的获取
     */
    @Test
    public void contextLoads() {
        TestData test = testDao.selectData();
        System.out.println(JSON.toJSONString(test));
    }


    @Autowired
    private TemperatureDao mapper;

    @Before
    public void before() {
        mapper.dropSuperTable();
        // create table temperature
        mapper.createSuperTable();
        // create table t_X using temperature
        for (int i = 0; i < 10; i++) {
            mapper.createTable("t" + i, locations[random.nextInt(locations.length)], i);
        }
        // insert into table
        int affectRows = 0;
        // insert 10 tables
        for (int i = 0; i < 10; i++) {
            // each table insert 5 rows
            for (int j = 0; j < 5; j++) {
                Temperature one = new Temperature();
                one.setTs(new Timestamp(1605024000000l));
                one.setTemperature(random.nextFloat() * 50);
                one.setLocation("望京");
                one.setTbIndex(i);
                affectRows += mapper.insertOne(one);
            }
        }
        Assert.assertEquals(50, affectRows);
    }

    @Test
    public void testInsert() {
        Temperature one = new Temperature();
        one.setTs(new Timestamp(1605024000000l));
        one.setTemperature(random.nextFloat() * 50);
        one.setLocation("望京");
        int affectRows = mapper.insertOne(one);
        Assert.assertEquals(1, affectRows);
    }


}
