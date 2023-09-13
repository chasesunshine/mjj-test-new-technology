package org.dongfu.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.dongfu.dao.source1dao.TestUser1Dao;
import org.dongfu.service.TestUser1Service;
import org.dongfu.entity.TestUser1;
import javax.annotation.Resource;

/**
 * (SpringWord)表服务实现类
 *
 * @author makejava
 * @since 2022-06-16 10:17:43
 */
@Slf4j
@Service
public class TestUser1ServiceImpl implements TestUser1Service {
    @Resource
    private TestUser1Dao testUser1Dao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TestUser1 queryById(Long id) {
        log.info("通过ID查询单条数据");

        TestUser1 testUser1 = testUser1Dao.queryById(id);
        return testUser1;
    }

}
