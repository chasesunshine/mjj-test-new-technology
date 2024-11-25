package org.wanbang.controller;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wanbang.entity.User;

/**
 * (SpringWord)表控制层
 *
 * @author makejava
 * @since 2022-06-16 10:17:35
 */
@Slf4j
@RestController
@RequestMapping("springWordTestxxx")
public class SpringWordTestController {

    @ModelAttribute("user")
    public User addAccount() {
        return new User(3L,18,"jz","123","456");
    }

    @RequestMapping(value = "/helloWorld")
    public String helloWorld(@ModelAttribute("user") User user) {
        user.setName("jizhou");
        System.out.println(JSON.toJSONString(user));
        return "helloWorld";
    }

}



