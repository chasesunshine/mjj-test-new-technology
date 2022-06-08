package com.dongfu.controller;

import com.dongfu.service.WorldUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("world/user")
public class WorldUserController {
    @Resource
    private WorldUserService worldUserService;

    @GetMapping("/selectOne")
    public String  selectOne(){
        String s = worldUserService.selectOne();
        return s;
    }

}
