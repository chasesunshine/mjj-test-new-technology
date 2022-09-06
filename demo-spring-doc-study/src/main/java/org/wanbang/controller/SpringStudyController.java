package org.wanbang.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.*;
import org.testspring.test2.TestSpringContainer2;
import org.wanbang.entity.SpringStudy;
import org.wanbang.service.SpringStudyService;
import org.wanbang.test1.TestSpringContainer;

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
//    @Resource
//    private TestSpringContainer2 testSpringContainer2;

    @GetMapping("/selectOne")
    public String selectOne() {
        SpringStudy springStudy = springStudyService.queryById((long) 1);
        return JSON.toJSONString(springStudy);
    }

    @GetMapping("/testSpringContainer1")
    public String testSpringContainer1() {
        String test = testSpringContainer.test();
        return JSON.toJSONString(test);
    }

    /**
     * TestSpringContainer2 这个类不在 启动类所在包下，所以加载不到容器中，包扫描机制没有扫描到 - 因此报错
     */
//    @GetMapping("/testSpringContainer2")
//    public String testSpringContainer2() {
//        String test = testSpringContainer2.test();
//        return JSON.toJSONString(test);
//    }

}

