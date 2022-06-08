package com.dongfu.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dongfu.entity.WorldUser;
import com.dongfu.mapper.WorldUserMapper;
import com.dongfu.service.WorldUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class WorldUserServiceImpl implements WorldUserService {

    @Resource
    private WorldUserMapper userMapper;

    /**
     *
     * @return
     */
    @Override
    public String selectOne() {
        WorldUser worldUser = userMapper.selectOne(Wrappers.<WorldUser>query().lambda()
                .eq(WorldUser::getId, 1));
        return JSON.toJSONString(worldUser);
    }

}
