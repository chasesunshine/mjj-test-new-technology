package org.wanbang.service.impl;

import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wanbang.config.spring.SpringContextUtil;
import org.wanbang.dao.TemperatureDao;
import org.wanbang.dao.TestDataDao;
import org.wanbang.dao.TestDataSecondDao;
import org.wanbang.dao.UserDao;
import org.wanbang.entity.TestData;
import org.wanbang.entity.TestDataSecond;
import org.wanbang.entity.User;
import org.wanbang.service.UserService;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * (SpringWord)表服务实现类
 *
 * @author makejava
 * @since 2022-06-16 10:17:43
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Resource
    private TestDataDao testDao;

    @Resource
    private TestDataSecondDao testDataSecondDao;

    @Autowired
    private TemperatureDao mapper;

    @PostConstruct
    public void test1(){
        log.info("@PostConstruct 第一次加载");
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Long id) {
        log.info("通过ID查询单条数据");

        mapper.createSuperTable();



        TestData test = testDao.selectData();

        TestDataSecond test2 = testDataSecondDao.selectData2();

        List<Map<String, Object>> value = testDao.selectData1("d1001");

        List<Map<String, Object>> value1 = testDataSecondDao.selectData("test_data_second");


        try {
            DynamicRoutingDataSource dynamicRoutingDataSource = SpringContextUtil.getBean("dataSource");
            Map<String, DataSource> dataSources = dynamicRoutingDataSource.getDataSources();
            DataSource tDengine = dataSources.get("tdengine");
            Connection connection = tDengine.getConnection();
            Statement stmt = connection.createStatement();



//            stmt.execute("CREATE TABLE IF NOT EXISTS sys_device_log_test1 (\n" +
//                    "    time TIMESTAMP,\n" +
//                    "    device_name NCHAR(255),\n" +
//                    "    product_id BIGINT UNSIGNED,\n" +
//                    "    product_key VARCHAR(32),\n" +
//                    "    product_name NCHAR(120),\n" +
//                    "    model_name NCHAR(120),\n" +
//                    "    data_type TINYINT,\n" +
//                    "    value_str NCHAR(512),\n" +
//                    "    value_double DOUBLE,\n" +
//                    "    times INT UNSIGNED,\n" +
//                    "    unit NCHAR(20),\n" +
//                    "    value_msg NCHAR(120)\n" +
//                    ") TAGS (device_id VARCHAR(36), device_mac VARCHAR(32), model_id BIGINT UNSIGNED, function_type TINYINT, identifier NCHAR(120));");
//            stmt.execute("CREATE TABLE sys_device_log_test1_device1 USING sys_device_log_test1 TAGS (\"device_id1\", \"mac1\",1,1,\"identifier1\");");
//            stmt.execute("INSERT INTO sys_device_log_test1_device1 USING sys_device_log_test1 TAGS (\"device_id1\", \"mac1\",1,1,\"identifier1\") VALUES (\"2023-09-04 00:00:01.000 \", \"device_name1\",1,\"product_key1\",\"product_name1\",\"model_name1\",1,\"value_str1\",1,1,\"unit1\",\"value_msg1\");");


//            stmt.execute("CREATE STABLE meters (ts timestamp, current float, voltage int, phase float) TAGS (location binary(64), groupId int);");
//            stmt.execute("CREATE TABLE d1001 USING meters TAGS (\"California.SanFrancisco\", 2);");
//            stmt.execute("INSERT INTO d1001 USING meters TAGS (\"California.SanFrancisco\", 2) VALUES ('2024-04-25 14:39:26.106', 10.2, 219, 0.32,'1234');");
//            stmt.execute("INSERT INTO d1002 USING meters TAGS (\"California.SanFrancisco\", 3) VALUES (NOW, 10.2, 219, 0.32);");
//            stmt.execute("INSERT INTO d1002 USING meters TAGS (\"California.SanFrancisco\", 3) VALUES (NOW, 10, 21, 0.3);");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return this.userDao.selectById(id);
    }

    @PostConstruct
    public void test2(){
        log.info("@PostConstruct 第二次加载");
    }
}
