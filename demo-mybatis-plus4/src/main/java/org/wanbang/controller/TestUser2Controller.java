package org.wanbang.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wanbang.entity.TestUser2;
import org.wanbang.service.TestUser2Service;
import javax.annotation.Resource;

/**
 * (SpringWord)表控制层
 *
 * @author makejava
 * @since 2022-06-16 10:17:35
 */
@RestController
@RequestMapping("/testUser2")
public class TestUser2Controller {
    @Resource
    private TestUser2Service testUser2Service;

    @GetMapping("/selectOne")
    public String selectOne() {
        TestUser2 testUser2 = testUser2Service.queryById((long) 11);
        return JSON.toJSONString(testUser2);
    }
}

