package org.wanbang.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/swaggerTest")
@Api("测试swagger")
public class HelloController {


    //    @RequestMapping("/hello")
    @ApiOperation("测试hello")
    @GetMapping(value="/hello")
    public String hello(){
        return "hello";
    }
}
