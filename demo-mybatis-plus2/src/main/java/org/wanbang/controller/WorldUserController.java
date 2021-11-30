package org.wanbang.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wanbang.service.WorldUserService;

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

    @GetMapping("/inset")
    public Integer insetOne(){
        Integer s = worldUserService.insertOnedata();
        return s;
    }

}
