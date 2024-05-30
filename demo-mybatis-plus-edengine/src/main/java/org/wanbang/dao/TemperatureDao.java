package org.wanbang.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.wanbang.entity.Temperature;

@DS("tdengine2")
@Mapper
public interface TemperatureDao extends BaseMapper<Temperature> {

    @Update("CREATE TABLE if not exists temperature(ts timestamp, temperature float) tags(location nchar(64), tbIndex int)")
    int createSuperTable();

    @Update("create table #{tbName} using temperature tags( #{location}, #{tbindex})")
    int createTable(@Param("tbName") String tbName, @Param("location") String location, @Param("tbindex") int tbindex);

    @Update("drop table if exists temperature")
    void dropSuperTable();

    @Insert("insert into t${tbIndex}(ts, temperature) values(#{ts}, #{temperature})")
    int insertOne(Temperature one);

}
