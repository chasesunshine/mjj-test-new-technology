package org.wanbang.study.allDesignMode.constructMode.appearanceMode.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.wanbang.study.allDesignMode.constructMode.appearanceMode.annotation.DoDoor;
import org.wanbang.study.allDesignMode.constructMode.appearanceMode.entity.UserInfo;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/12 19:59
* @version 1.0
*/

@Slf4j
@RestController
public class MjjTestController {
    /**
     * http://localhost:8080/api/queryUserInfo?userId=1001
     * http://localhost:8080/api/queryUserInfo?userId=⼩团团
     */
    @DoDoor(key = "userId", returnJson = "{\"code\":\"1111\",\"info\":\"⾮⽩名单可访问⽤户拦截！\"}")
    @GetMapping(path = "/api/queryUserInfo")
    public UserInfo queryUserInfo(@RequestParam(value = "userId") String userId) {
        return new UserInfo("⾍⾍:" + userId, 19, "天津市南开区旮旯胡同100号");
    }
}
