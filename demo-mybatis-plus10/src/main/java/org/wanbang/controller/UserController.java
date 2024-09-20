package org.wanbang.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.wanbang.entity.TestValue;
import org.wanbang.entity.User;
import org.wanbang.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * (SpringWord)表控制层
 *
 * @author makejava
 * @since 2022-06-16 10:17:35
 */
@Slf4j
@RestController
@RequestMapping("springWordTest10")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/selectOne")
    public String selectOne() {
        User user = userService.queryById((long) 1);
        return JSON.toJSONString(user);
    }

//    @GetMapping("/selectTwo")
//    public String selectTwo(@RequestBody TestValue test) {
//        User user = userService.queryById((long) 1);
//        return JSON.toJSONString(user);
//    }

//    @GetMapping("/selectTwo")
//    public String selectTwo() {
//        User user = userService.queryById((long) 1);
//        return JSON.toJSONString(user);
//    }

    @PostMapping("/selectTwo")
    public String selectTwo(@RequestBody TestValue test) {
        User user = userService.queryById((long) 1);
        return JSON.toJSONString(user);
    }

}

