package org.wanbang.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.wanbang.entity.TestData;

/**
 * (SpringWord)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-16 10:17:36
 */
@DS("tdengine")
@Repository
public interface TestDataDao extends BaseMapper<TestData> {
    TestData selectData();
}

