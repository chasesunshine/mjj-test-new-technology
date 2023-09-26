package org.wanbang.controller;

import org.wanbang.service.TestRedisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * https://www.cnblogs.com/ll409546297/p/10956960.html
 *
 */
@RestController
@RequestMapping("test/redis")
public class TestRedisController {
    @Resource
    private TestRedisService testRedisService;

    @GetMapping("/insert")
    public void testRedisInsert(@RequestParam(value = "key" ,required = false)String key,@RequestParam(value = "value", required = false)String value) {
        testRedisService.testRedisInsert(key,value);
    }

}
