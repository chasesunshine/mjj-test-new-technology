package org.wanbang.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.wanbang.entity.TestData;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

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

    List<Map<String, Object>> selectData1(@Param("table") String table);
}

