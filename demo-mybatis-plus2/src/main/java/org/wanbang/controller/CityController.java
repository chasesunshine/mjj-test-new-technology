package org.wanbang.controller;

import org.wanbang.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping("/selectOne")
    public String  selectOne(){
        String s = cityService.selectOne();
        return s;
    }
}
