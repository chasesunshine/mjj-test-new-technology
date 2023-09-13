package org.dongfu.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/lm")
public class HelloController {

    @RequestMapping("/hello1")
    public String hello(@RequestBody JSONObject jsonObject){
        return "hello 1:"+jsonObject.getString("name");
    }

    @RequestMapping("/hello2")
    public String hello(@RequestParam("name") String name){
        return "hello 2:"+name;
    }
}
