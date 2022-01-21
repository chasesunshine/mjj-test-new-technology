package com.example.rocketmq.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.rocketmq.entity.City;
import com.example.rocketmq.mapper.CityMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CityService {
    @Autowired
    private CityMapper cityMapper;

    public String selectOne() {
        City city = cityMapper.selectOne(Wrappers.<City>query().lambda()
                .eq(City::getId,1));

        return JSON.toJSONString(city);
    }
}
