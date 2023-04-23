package org.wanbang.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.*;
import org.wanbang.entity.SpringWorld;
import org.wanbang.service.SpringWordService;

import javax.annotation.Resource;

/**
 * (SpringWord)表控制层
 *
 * @author makejava
 * @since 2022-06-16 10:17:35
 */
@RestController
@RequestMapping("springWordTest5")
public class SpringWordController {
    @Resource
    private SpringWordService springWordService;

    @GetMapping("/selectOne")
    public String selectOne() {
        SpringWorld springWorld = springWordService.queryById((long) 1);
        return JSON.toJSONString(springWorld);
    }
}

