package org.wanbang.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.*;
import org.wanbang.entity.TestUser1;
import org.wanbang.service.TestUser1Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * (SpringWord)表控制层
 *
 * @author makejava
 * @since 2022-06-16 10:17:35
 */
@RestController
@RequestMapping("/testUser1")
public class TestUser1Controller {
    @Resource
    private TestUser1Service testUser1Service;

    @GetMapping("/selectOne")
    public String selectOne() {
        TestUser1 testUser1 = testUser1Service.queryById((long) 1);
        return JSON.toJSONString(testUser1);
    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);

    }
}

