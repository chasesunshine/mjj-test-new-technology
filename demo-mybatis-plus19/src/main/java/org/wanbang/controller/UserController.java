package org.wanbang.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.wanbang.entity.User;
import org.wanbang.service.UserService;

import javax.annotation.Resource;

/**
 * (SpringWord)表控制层
 *
 * @author makejava
 * @since 2022-06-16 10:17:35
 */
@Slf4j
@RestController
@RequestMapping("springWord")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/selectOne")
    public String selectOne() {
        User user = userService.queryById((long) 1);
        return JSON.toJSONString(user);
    }
}

