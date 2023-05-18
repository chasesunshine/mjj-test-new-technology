package org.dongfu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.dongfu.entity.User;

/**
 * (SpringWord)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-16 10:17:36
 */
public interface UserDao extends BaseMapper<User> {
    /*登录方法*/
    User login(User user);
}

