package org.wanbang.controller;


import com.alibaba.fastjson.JSON;
import org.wanbang.entity.RedisMysqlConsistency;
import org.wanbang.service.RedisMysqlConsistencyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jjh
 * @since 2022-11-18
 */
@RestController
@RequestMapping("/user")
public class RedisMysqlConsistencyController {
    @Resource
    private RedisMysqlConsistencyService redisMysqlConsistencyService;

    @GetMapping("/selectOne")
    public String selectOne() {
        RedisMysqlConsistency redisMysqlConsistency = redisMysqlConsistencyService.queryById(1);
        return JSON.toJSONString(redisMysqlConsistency);
    }

    @GetMapping("/insertOne")
    public String insertOne() {
        Integer rows = redisMysqlConsistencyService.insertData();
        return JSON.toJSONString(rows);
    }

}
