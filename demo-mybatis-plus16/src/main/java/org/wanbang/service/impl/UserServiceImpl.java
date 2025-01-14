package org.wanbang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.wanbang.dao.UserMapper;
import org.wanbang.entity.User;
import org.wanbang.service.UserService;
import org.wanbang.validationTest.MyService;
import org.wanbang.validationTest.UserEntity;

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
    private UserMapper userMapper;

    @Resource
    private MyService myService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(String name) {
        log.info("通过ID查询单条数据");
        return this.userMapper.selectOne(new QueryWrapper<User>().lambda().eq(User::getName,name));
    }

    @Override
    public String testValidate() {
        UserEntity userEntity = new UserEntity();
        userEntity.setPhoneNum("q");
        userEntity.setName("fxjk");
        userEntity.setId("123");

        String s = myService.processOrder(userEntity);
        return s;
    }


}
