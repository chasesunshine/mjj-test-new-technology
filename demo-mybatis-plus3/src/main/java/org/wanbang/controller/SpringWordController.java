package org.wanbang.controller;

import org.springframework.web.bind.annotation.*;
import org.wanbang.entity.SpringWord;
import org.wanbang.service.SpringWordService;

import javax.annotation.Resource;

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
        SpringWord springWord = springWordService.queryById((long) 1);
        return springWord.toString();
    }
}

