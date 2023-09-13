package org.dongfu.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.dongfu.entity.City;
import org.dongfu.mapper.CityMapper;

@Service
@Slf4j
public class CityServiceTestAop {
    @Autowired
    private CityMapper cityMapper;

    public String selectOne() {
        City city = cityMapper.selectOne(Wrappers.<City>query().lambda()
                .eq(City::getId,1));

        return JSON.toJSONString(city);
    }
}
