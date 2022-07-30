package org.wanbang.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.*;
import org.wanbang.entity.SpringWorld;
import org.wanbang.service.SpringWordService;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * (SpringWord)表控制层
 *
 * @author makejava
 * @since 2022-06-16 10:17:35
 */
@RestController
@RequestMapping("springWord")
public class SpringWordController {
    @Resource
    private SpringWordService springWordService;

    @GetMapping("/selectOne")
    public String  selectOne(){
        SpringWorld springWorld = springWordService.queryById((long) 1);
        return JSON.toJSONString(springWorld);
    }

//    public static void main(String[] args) {
//        SpringWorld build = SpringWorld.builder().age(1).value(3).build();
//        SpringWorld build1 = SpringWorld.builder().age(2).value(3).build();
//        SpringWorld build2 = SpringWorld.builder().age(1).value(4).build();
//        SpringWorld build3 = SpringWorld.builder().age(2).value(4).build();
//        SpringWorld build4 = SpringWorld.builder().age(2).value(4).build();
//        SpringWorld build5 = SpringWorld.builder().age(3).value(5).build();
//        SpringWorld build6 = SpringWorld.builder().age(1).value(5).build();
//
//        List<SpringWorld> springWorlds = Arrays.asList(build, build1, build2, build3, build4, build5, build6);
//
//        System.out.println(JSON.toJSONString(springWorlds));
//
//        Arrays.sort(springWorlds, new Comparator<SpringWorld>() {
//            @Override
//            public int compare(SpringWorld o1, SpringWorld o2) {
//                Integer age1 = o1.getAge();
//                Integer age2 = o2.getAge();
//                Integer value1 = o1.getValue();
//                Integer value2 = o2.getValue();
//                if(age1 > age2){
//                    return 1;
//                }
//                if(age1 == age2){
//                    if(value1 > value2){
//                        return 1;
//                    }
//                }
//            }
//        });
//    }

}

