package org.wanbang;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wanbang.dao.UserRepository;
import org.wanbang.entity.User;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author rtxtitanv
 * @version 1.0.0
 * @name com.rtxtitanv.MongodbTest
 * @description SpringDataMongoDB单元测试类
 * @date 2021/5/26 18:11
 */
@RunWith(SpringRunner.class)	//注意测试文件的位置 必须在主文件加载包路径下
@SpringBootTest
class MongodbTest {

    @Resource
    private UserRepository userRepository;
    private static Logger logger = LoggerFactory.getLogger(MongodbTest.class);

    /**
     * 保存测试，这里保存5条测试文档，一次插入一条文档
     * 使用方法 <S extends T> S save(S var1)
     */
    @Test
    public void testSave() {
        User user;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        user = userRepository.save(new User().setUsername("guanyuchang123").setPassword("a123456").setRealname("关羽")
                .setGender("男").setAge(28).setEmail("yunchang@xxx.com").setUserPoint(100).setUserLevel(Byte.valueOf("1"))
                .setBirthday(LocalDateTime.parse("1992-10-01 17:15:20", dateTimeFormatter)));
        logger.info(user.toString());
        user = userRepository.save(new User().setUsername("qiaolaoda888").setPassword("ss0635gh").setRealname("大乔")
                .setGender("女").setAge(20).setEmail("daqiao@xxx.com").setUserPoint(360).setUserLevel(Byte.valueOf("1"))
                .setBirthday(LocalDateTime.parse("2000-12-25 13:22:32", dateTimeFormatter)));
        logger.info(user.toString());
        user = userRepository.save(new User().setUsername("feige45").setPassword("qwer1234aa").setRealname("张飞")
                .setGender("男").setAge(25).setEmail("yide@xxx.com").setUserPoint(1000).setUserLevel(Byte.valueOf("3"))
                .setBirthday(LocalDateTime.parse("1995-05-16 08:10:15", dateTimeFormatter)));
        logger.info(user.toString());
        user = userRepository.save(new User().setUsername("zilongzhao01").setPassword("qscrdx265").setRealname("赵云")
                .setGender("男").setAge(21).setEmail("zilong@xxx.com").setUserPoint(666).setUserLevel(Byte.valueOf("2"))
                .setBirthday(LocalDateTime.parse("1999-11-27 22:15:25", dateTimeFormatter)));
        logger.info(user.toString());
        user = userRepository.save(new User().setUsername("qiaoxiaomei886").setPassword("123wwqqs36").setRealname("小乔")
                .setGender("女").setAge(18).setEmail("xiaoqiao@xxx.com").setUserPoint(2500).setUserLevel(Byte.valueOf("4"))
                .setBirthday(LocalDateTime.parse("2002-09-06 12:28:33", dateTimeFormatter)));
        logger.info(user.toString());
    }


}

