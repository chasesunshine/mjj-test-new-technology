package org.wanbang.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wanbang.config.properties.TemplateProperties;
import org.wanbang.entity.City;
import org.wanbang.mapper.CityMapper;
import org.wanbang.service.CityService;

import javax.annotation.Resource;

@Service
@Slf4j
public class CityServiceImpl implements CityService {
    @Resource
    private CityMapper cityMapper;

    @Resource
    private TemplateProperties templateProperties;

    @Override
    public String selectOne() {
        City city = cityMapper.selectOne(Wrappers.<City>query().lambda()
                .eq(City::getId,1));

        return JSON.toJSONString(city);
    }

    @Override
    public String testConfigProperties() {
        String purchaseOrderDeliverGoodsExcel = templateProperties.getPurchaseOrderDeliverGoodsExcel();
        return purchaseOrderDeliverGoodsExcel;
    }

}
