package org.wanbang.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.*;
import org.wanbang.entity.SpringStudy;
import org.wanbang.service.SpringStudyService;
import org.wanbang.test.TestSpringContainer;

import javax.annotation.Resource;

/**
 * (SpringWord)表控制层
 *
 * @author makejava
 * @since 2022-06-16 10:17:35
 */
@RestController
@RequestMapping("springStudy")
public class SpringStudyController {
    @Resource
    private SpringStudyService springStudyService;
    @Resource
    private TestSpringContainer testSpringContainer;

    @GetMapping("/selectOne")
    public String selectOne() {
        SpringStudy springStudy = springStudyService.queryById((long) 1);
        return JSON.toJSONString(springStudy);
    }

    @GetMapping("/testSpringContainer")
    public String testSpringContainer() {
        String test = testSpringContainer.test();
        return JSON.toJSONString(test);
    }

}

