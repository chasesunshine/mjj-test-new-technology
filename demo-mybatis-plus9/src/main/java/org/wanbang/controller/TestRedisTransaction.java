package org.wanbang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.wanbang.service.TestRedisService;

import javax.annotation.Resource;

/**
 * https://www.cnblogs.com/ll409546297/p/10956960.html
 *
 */
@RestController
@RequestMapping("test/redis")
public class TestRedisTransaction {
    @Resource
    private TestRedisService testRedisService;

    @GetMapping("/transaction")
    public String executeTransaction() {
        testRedisService.executeTransaction();
        return "Transaction executed successfully";
    }

    @GetMapping("/rollback")
    public String rollbackTransaction() {
        testRedisService.rollbackTransaction();
        return "Transaction rolled back successfully";
    }

}
