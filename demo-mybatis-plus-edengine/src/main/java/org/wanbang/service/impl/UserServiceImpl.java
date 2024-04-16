package org.wanbang.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.wanbang.dao.TestDataDao;
import org.wanbang.dao.UserDao;
import org.wanbang.entity.TestData;
import org.wanbang.entity.User;
import org.wanbang.service.UserService;

import javax.annotation.Resource;

/**
 * (SpringWord)表服务实现类
 *
 * @author makejava
 * @since 2022-06-16 10:17:43
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Resource
    private TestDataDao testDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Long id) {
        log.info("通过ID查询单条数据");
        TestData test = testDao.selectData();

        return this.userDao.selectById(id);
    }


}
