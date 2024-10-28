package org.wanbang.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wanbang.dao.UserDao;
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

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Long id) {
        log.info("通过ID查询单条数据");
        return this.userDao.selectById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer insertData() {
        User build = User.builder().age(18).name("mjj").password("123").sex("男").build();
        int insert = userDao.insert(build);
        return insert;
    }

}
