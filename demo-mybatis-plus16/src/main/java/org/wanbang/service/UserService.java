package org.wanbang.service;

import org.wanbang.entity.User;

import java.util.List;

/**
 * (SpringWord)表服务接口
 *
 * @author makejava
 * @since 2022-06-16 10:17:42
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(String name);

    String testValidate();

    List<User> selectData(int pageNum, int pageSize);
}
