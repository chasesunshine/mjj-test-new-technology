package org.wanbang.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.wanbang.convert.UserConver;
import org.wanbang.mapper.UserMapper;
import org.wanbang.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wanbang.entity.common.UserVo;
import org.wanbang.entity.common.UserVo1;

import javax.annotation.Resource;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Resource
    private UserConver UserConver;

    public String selectOne() {
        User user = userMapper.selectOne(Wrappers.<User>query().lambda()
                .eq(User::getId,7));

        UserVo userVo = UserConver.item2Dto(user);

        UserVo1 convert = UserConver.convert(user);

        return JSON.toJSONString(user);
    }
}
