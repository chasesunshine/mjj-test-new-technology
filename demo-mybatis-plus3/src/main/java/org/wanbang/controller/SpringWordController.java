package org.wanbang.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.*;
import org.wanbang.entity.SpringWorld;
import org.wanbang.service.SpringWordService;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (SpringWord)表控制层
 *
 * @author makejava
 * @since 2022-06-16 10:17:35
 */
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@RestController
@RequestMapping("springWord")
public class SpringWordController {
    @Resource
    private SpringWordService springWordService;

    @GetMapping("/selectOne")
    public String selectOne() {
        SpringWorld springWorld = springWordService.queryById((long) 1);
        return JSON.toJSONString(springWorld);
    }

    @GetMapping("/updateOne")
    public String updateOne() {
        SpringWorld springWorld = springWordService.updateOne((long) 1);
        return JSON.toJSONString(springWorld);
    }

    @GetMapping("/updateTwo")
    public String updateTwo() {
        SpringWorld springWorld = springWordService.updateTwo((long) 2);
        return JSON.toJSONString(springWorld);
    }

    public static void main(String[] args) {
        SpringWorld build = SpringWorld.builder().age(1).value(3).build();
        SpringWorld build1 = SpringWorld.builder().age(2).value(3).build();
        SpringWorld build2 = SpringWorld.builder().age(1).value(4).build();
        SpringWorld build3 = SpringWorld.builder().age(2).value(4).build();
        SpringWorld build4 = SpringWorld.builder().age(2).value(4).build();
        SpringWorld build5 = SpringWorld.builder().age(3).value(5).build();
        SpringWorld build6 = SpringWorld.builder().age(1).value(5).build();

        List<SpringWorld> springWorlds = Arrays.asList(build, build1, build2, build3, build4, build5, build6);

        System.out.println(JSON.toJSONString(springWorlds));

        Comparator<Object> comparator = (o1, o2) -> {
            Integer age1 = ((SpringWorld) o1).getAge();
            Integer age2 = ((SpringWorld) o2).getAge();

            Integer value1 = ((SpringWorld) o1).getValue();
            Integer value2 = ((SpringWorld) o2).getValue();

            if (age1.compareTo(age2) != 0) {
                return age1.compareTo(age2);
            }else {
                if(value1.compareTo(value2) != 0){
                    if(value1 > value2){
                        return -1;
                    }else {
                        return 1;
                    }
                }else {
                    return 0;
                }
            }
        };

        List<SpringWorld> collect = springWorlds.stream().sorted(comparator.reversed()).collect(Collectors.toList());
        List<SpringWorld> collect1 = springWorlds.stream().sorted(comparator).collect(Collectors.toList());

        System.out.println(JSON.toJSONString(collect));
        System.out.println(JSON.toJSONString(collect1));
    }

}

