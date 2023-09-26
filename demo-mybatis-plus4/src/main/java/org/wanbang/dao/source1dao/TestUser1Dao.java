package org.wanbang.dao.source1dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.wanbang.entity.TestUser1;

/**
 * (SpringWord)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-16 10:17:36
 */
public interface TestUser1Dao extends BaseMapper<TestUser1> {

    TestUser1 queryById(@Param("id") Long id);

}

