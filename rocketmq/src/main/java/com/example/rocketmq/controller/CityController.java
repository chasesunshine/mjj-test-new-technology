package com.example.rocketmq.controller;

import com.example.rocketmq.common.enums.CacheNameEnum;
import com.example.rocketmq.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("city")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping("/selectOne")
    public String  selectOne(){
        String s = cityService.selectOne();
        String fxjk = CacheNameEnum.SVC_NODE_ID.formatOrgId("fxjk");
        return s;
    }
}
