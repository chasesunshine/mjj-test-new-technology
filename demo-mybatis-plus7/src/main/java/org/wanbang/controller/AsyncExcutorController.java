package org.wanbang.controller;

import lombok.extern.slf4j.Slf4j;
import org.wanbang.service.AsyncExcutorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("springWordTestAsync")
public class AsyncExcutorController {
    @Resource
    private AsyncExcutorService AsyncExcutorService;

    @GetMapping("/test1")
    public void selectOne1() {
        AsyncExcutorService.service1();
    }

    @GetMapping("/test2")
    public void selectOne2() {
        AsyncExcutorService.service2();
    }
}
