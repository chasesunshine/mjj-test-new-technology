package org.wanbang.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.*;
import org.testspring.test2.TestSpringContainer2;
import org.wanbang.entity.SpringStudy;
import org.wanbang.service.SpringStudyService;
import org.wanbang.test1.TestSpringContainer;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    public static void main(String[] args) {
        String s = "1";
        String[] split = s.split(",");

        List<String> strings = Arrays.asList(split);
        System.out.println(JSON.toJSONString(strings));

//        String lock ="mjj_lock";
//        byte[] a = lock.getBytes();
//        long l = Long.parseLong(new String(a));
//        System.out.println(l);


//        SpringStudy build = SpringStudy.builder().id((long) 1).age(1).name("2").sex("44").build();
//        SpringStudy build1 = SpringStudy.builder().id((long) 2).age(1).name("2").sex("55").build();
//        SpringStudy build2 = SpringStudy.builder().id((long) 3).age(1).name("2").sex("66").build();
//        SpringStudy build3 = SpringStudy.builder().id((long) 4).age(2).name("2").sex("77").build();
//        SpringStudy build4 = SpringStudy.builder().id((long) 5).age(2).name("3").sex("44").build();
//        SpringStudy build5 = SpringStudy.builder().id((long) 6).age(2).name("3").sex("44").build();
//
//        List<SpringStudy> objects = new ArrayList<>();
//
//        objects.add(build);
//        objects.add(build1);
//        objects.add(build2);
//        objects.add(build3);
//        objects.add(build4);
//        objects.add(build5);
//
//        List<SpringStudy> collect = objects.stream().filter(v -> v.getAge() == 2  )
//                .collect(Collectors.toList());
//        System.out.println(JSON.toJSONString(collect));

//        Integer num = 9322;
//        int pageSize = num / 100;
//        for (int j = 0; j <= pageSize; j++) {
//            System.out.println(j);
//        }
    }
}

