package org.wanbang.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wanbang.service.MongoDBMysqlService;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("mongoDBMysqlController")
public class MongoDBMysqlController {
    @Resource
    private MongoDBMysqlService mongoDBMysqlService;

    @GetMapping("/insertData")
    public Integer insertData() {
        Integer count = mongoDBMysqlService.insertData();
        return count;
    }


}
