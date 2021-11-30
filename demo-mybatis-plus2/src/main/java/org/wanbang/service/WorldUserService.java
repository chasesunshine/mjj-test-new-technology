package org.wanbang.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.wanbang.entity.WorldUser;
import org.wanbang.mapper.WorldUserMapper;

import javax.annotation.Resource;

@Service
@Slf4j
public class WorldUserService {
    @Resource
    private WorldUserMapper userMapper;

    public String selectOne() {
        WorldUser worldUser = userMapper.selectOne(Wrappers.<WorldUser>query().lambda()
                .eq(org.wanbang.entity.WorldUser::getId, 1));

        return JSON.toJSONString(worldUser);
    }

    public Integer insertOnedata() {
        int mjj = userMapper.insertdData(WorldUser.builder().name("mjj1234").age(20).build());
        return mjj;
    }
}
