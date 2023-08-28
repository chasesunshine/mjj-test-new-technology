package org.dongfu.controller;

import com.alibaba.fastjson.JSON;
import org.dongfu.config.TestProperties;
import org.dongfu.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (SpringWord)表控制层
 *
 * @author makejava
 * @since 2022-06-16 10:17:35
 */
@RestController
@RequestMapping("springWordTest8")
public class UserController {
    @Resource
    private UserService userService;

    @Resource
    private TestProperties TestProperties;

    @GetMapping("/selectOne")
    public String selectOne() {
        String user = userService.queryById((long) 1);

        String group = TestProperties.getGroup();
        String namesrvAddr = TestProperties.getNamesrvAddr();

        return JSON.toJSONString(group+" - "+namesrvAddr);
    }

}

