package com.dongfu.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dongfu.entity.WorldUser1;
import com.dongfu.mapper.WorldUserMapper1;
import com.dongfu.service.WorldUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class WorldUserServiceImpl implements WorldUserService {

    @Resource
    private WorldUserMapper1 userMapper;

    /**
     *
     * @return
     */
    @Override
    public String selectOne() {
        log.info("日志输出");
        WorldUser1 worldUser = userMapper.selectOne(Wrappers.<WorldUser1>query().lambda()
                .eq(WorldUser1::getId, 1));
        return JSON.toJSONString(worldUser);
    }

    @Override
    public String selectOne1() {
        log.info("日志输出");
        WorldUser1 worldUser = userMapper.selectData();
        return JSON.toJSONString(worldUser);
    }
}
