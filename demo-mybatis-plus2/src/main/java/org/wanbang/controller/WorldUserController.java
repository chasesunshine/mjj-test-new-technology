package org.wanbang.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.wanbang.common.Result;
import org.wanbang.entity.WorldUser;
import org.wanbang.service.WorldUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping("world/user")
public class WorldUserController {
    @Autowired
    private WorldUserService worldUserService;

    @GetMapping("/selectOne")
    public String  selectOne(){
        String s = worldUserService.selectOne();
        return s;
    }

    @GetMapping("/inset/mybatis")
    public Integer insetOneMybatis(@RequestParam("name") String name,@RequestParam("age")Integer age){
        Integer s = worldUserService.insertOnedata(name,age);
        return s;
    }

    @GetMapping("/inset/mybatis/test")
    public Result insetOneMybatisTest(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){
        Integer s = worldUserService.insetOneMybatisTest();
//        String traceId = (String) httpServletRequest.getAttribute("traceId");
        return Result.success(s,"traceId");
    }

    @GetMapping("/insret/mybatisplus")
    public Integer insertOneMybatisplus(@RequestParam("name") String name,@RequestParam("age")Integer age){
        Integer s = worldUserService.insert(name,age);
        return s;
    }

    @GetMapping("/selectTwo")
    public String  selectTwo(){
        String s = worldUserService.selectTwo();
        return s;
    }

    @PostMapping("/insetData")
    public String insetData(@RequestBody WorldUser worldUser){
        String s = worldUserService.insetData(worldUser);
        return s;
    }
}
