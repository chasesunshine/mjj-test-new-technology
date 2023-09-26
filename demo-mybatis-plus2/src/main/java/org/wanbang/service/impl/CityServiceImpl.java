package org.wanbang.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wanbang.config.properties.AuthDto;
import org.wanbang.config.properties.AuthProperties;
import org.wanbang.config.properties.TemplateProperties;
import org.wanbang.entity.City;
import org.wanbang.mapper.CityMapper;
import org.wanbang.service.CityService;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class CityServiceImpl implements CityService {
    @Resource
    private CityMapper cityMapper;

    @Resource
    private TemplateProperties templateProperties;

    @Resource
    private AuthProperties authProperties;

    @Override
    public String selectOne() {
        City city = cityMapper.selectOne(Wrappers.<City>query().lambda()
                .eq(City::getId,1));

        return JSON.toJSONString(city);
    }

    @Override
    public String testConfigProperties() {
        String purchaseOrderDeliverGoodsExcel = templateProperties.getPurchaseOrderDeliverGoodsExcel();

        List<String> paths = authProperties.getPaths();
        List<AuthDto> authList = authProperties.getAuthList();

        return purchaseOrderDeliverGoodsExcel;
    }

    @Transactional(rollbackFor = Exception.class)
    public String selectTwo() {
        City build1 = City.builder().name("mjj1").countryCode("1").district("11").population(111).build();
        City build2 = City.builder().countryCode("2").district("22").population(222).build();
        cityMapper.insert(build1);

        asnRewrite(build2);

        return JSON.toJSONString(build1);
    }

    private void asnRewrite(City build2) {
        cityMapper.insert(build2);
    }

}
