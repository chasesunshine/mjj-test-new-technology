package org.wanbang.service.impl;

import org.wanbang.service.UserService;
import org.springframework.stereotype.Service;

/**
 * (SpringWord)表服务实现类
 *
 * @author makejava
 * @since 2022-06-16 10:17:43
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public String queryById(Long id) {
        return "test";
    }

}
