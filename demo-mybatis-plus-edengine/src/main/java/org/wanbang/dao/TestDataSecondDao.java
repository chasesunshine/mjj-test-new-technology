package org.wanbang.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.wanbang.entity.TestData;
import org.wanbang.entity.TestDataSecond;

import java.util.List;
import java.util.Map;

/**
 * (SpringWord)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-16 10:17:36
 */
@DS("tdengine2")
@Repository
public interface TestDataSecondDao extends BaseMapper<TestDataSecond> {
    TestDataSecond selectData2();

    List<Map<String, Object>> selectData(@Param("table") String table);
}

