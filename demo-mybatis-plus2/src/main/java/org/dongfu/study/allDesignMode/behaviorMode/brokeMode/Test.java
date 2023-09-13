package org.dongfu.study.allDesignMode.behaviorMode.brokeMode;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.dongfu.study.allDesignMode.behaviorMode.brokeMode.mediator.Resources;
import org.dongfu.study.allDesignMode.behaviorMode.brokeMode.mediator.SqlSession;
import org.dongfu.study.allDesignMode.behaviorMode.brokeMode.mediator.SqlSessionFactory;
import org.dongfu.study.allDesignMode.behaviorMode.brokeMode.mediator.SqlSessionFactoryBuilder;
import org.dongfu.study.allDesignMode.behaviorMode.brokeMode.po.User;

import java.io.Reader;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/19 14:00
* @version 1.0
*/

public class Test {
    private static Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {

        String resource = "mybatis-config-datasource.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sqlMapper.openSession();
            try {
                User user = session.selectOne("org.itstack.demo.design.dao.IUserDao.queryUserInfoById", 1L);
                logger.info("测试结果：{}", JSON.toJSONString(user));
            } finally {
                session.close();
                reader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
