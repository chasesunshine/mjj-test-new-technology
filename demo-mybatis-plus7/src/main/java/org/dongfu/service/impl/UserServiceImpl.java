package org.dongfu.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.dongfu.dao.UserDao;
import org.dongfu.entity.User;
import org.dongfu.service.UserService;
import org.springframework.stereotype.Service;

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


    @Override
    public User login(User user) {
        //接受用户查询数据库
        User userDB = userDao.login(user);
        //查询到这个用户就返回，没有则抛出错误
        if (userDB != null) {
            return userDB;
        }else{
            throw new RuntimeException("登录失败！");
        }
    }
}
