package org.wanbang.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wanbang.dao.source2dao.TestUser2Dao;
import org.wanbang.entity.TestUser2;
import org.wanbang.service.TestUser2Service;
import javax.annotation.Resource;

/**
 * (SpringWord)表服务实现类
 *
 * @author makejava
 * @since 2022-06-16 10:17:43
 */
@Slf4j
@Service
public class TestUser2ServiceImpl implements TestUser2Service {
    @Resource
    private TestUser2Dao testUser2Dao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TestUser2 queryById(Long id) {
        log.info("通过ID查询单条数据");

        return this.testUser2Dao.selectById(id);
    }

    @Transactional(value = "source2TransactionManager")
    @Override
    public Integer insertOne() {
        TestUser2 testUser3 = new TestUser2();
        testUser3.setAge(11);
        testUser3.setName("马佳健测试 事务管理器");
        testUser3.setSex("男");
        testUser2Dao.insert(testUser3);


        TestUser2 testUser2 = new TestUser2();
        testUser2.setAge(11);
        testUser2.setName("马佳健测试 事务管理器");
        testUser2.setSex("马佳健测试 事务管理器");
        testUser2Dao.insert(testUser2);

        return null;
    }

}
