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

    public Integer insertOnedata(String name,Integer age) {
        int mjj = userMapper.insertOneData(WorldUser.builder().name(name).age(age).build());
        return mjj;
    }

    public Integer insert(String name,Integer age) {
        int mjj = userMapper.insert(WorldUser.builder().name(name).age(age).build());
        return mjj;
    }
}
