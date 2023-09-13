package org.dongfu.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.dongfu.common.enums.CacheNameEnum;
import org.dongfu.entity.City;
import org.dongfu.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.dongfu.service.CityServiceTestAop;
import org.dongfu.study.redisLock.LockExecutor;

import javax.annotation.Resource;
import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("city")
public class CityController {
    @Autowired
    private CityService cityService;

    @Autowired
    private CityServiceTestAop cityServiceTestAop;

    @Resource
    LockExecutor lockExecutor;

    @RequestMapping("/test-error1")
    public String testError1(@RequestBody @Valid City city) {
        return "success" + 1;
    }


    @GetMapping("/selectOne")
    public String  selectOne(){
        String s = cityService.selectOne();
        String fxjk = CacheNameEnum.SVC_NODE_ID.formatOrgId("fxjk");
        return s;
    }

    @GetMapping("/selectOne1")
    public String  selectOne1(){
        String s = cityServiceTestAop.selectOne();
        String fxjk = CacheNameEnum.SVC_NODE_ID.formatOrgId("fxjk");
        return s;
    }

    @GetMapping("/test/config/properties")
    public String testConfigProperties(){
        String s = cityService.testConfigProperties();
        return s;
    }

    @GetMapping("/selectOne2")
    public String  selectOne2(){
        String s = cityService.selectTwo();
        return s;
    }

    /**
     * 测试分布式锁
     *
     * @return
     */
//    @GetMapping("/redis/lock")
//    public String redisLock(){
//        String key = CacheNameEnum.DELIVER_LOCK.formatOrgId("fxjk","123");
//        return lockExecutor.exec(key, 10, () -> cityService.selectOne());
//    }
}
