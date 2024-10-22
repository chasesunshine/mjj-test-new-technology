package org.wanbang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wanbang.config.SnowFlakeGenerator;

import javax.annotation.Resource;

/**
 * 雪花算法
 *
 * @author wang.js on 2019/3/8.
 * @version 1.0
 */
@RequestMapping("/snowflake")
@RestController
public class SnowflakeController {

    @Resource
    private SnowFlakeGenerator snowFlakeGenerator;

    /**
     * 获取分布式主键
     *
     * @return
     */
    @GetMapping("/get")
    public long getDistributeId() {
        return snowFlakeGenerator.nextId();
    }

}

