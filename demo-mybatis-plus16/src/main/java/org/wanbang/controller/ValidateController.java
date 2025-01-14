package org.wanbang.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wanbang.entity.User;
import org.wanbang.param.RequestParam;
import org.wanbang.service.UserService;
import org.wanbang.util.raft.RaftRateLimiter;
import org.wanbang.util.raft.RateLimitedRaftRequestHandler2;

import javax.annotation.Resource;

/**
 * (SpringWord)表控制层
 *
 * @author makejava
 * @since 2022-06-16 10:17:35
 */
@Slf4j
@RestController
@RequestMapping("springWordTest16")
public class ValidateController {
    @Resource
    private UserService userService;

    @GetMapping("/testValidate")
    public String testValidate() {
        String result = userService.testValidate();
        return JSON.toJSONString(result);
    }

}

