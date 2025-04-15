package org.wanbang.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.wanbang.entity.User;

import java.util.List;

/**
 * (SpringWord)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-16 10:17:36
 */
public interface UserDao extends BaseMapper<User> {
    /**
     *
     */
    void login1();

    void batchInsert(@Param("param") List<User> copy);
}

