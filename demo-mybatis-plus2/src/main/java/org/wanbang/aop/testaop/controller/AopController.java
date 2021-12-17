package org.wanbang.aop.testaop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wanbang.aop.testaop.service.ICalculatorService;

@Slf4j
@RestController
@RequestMapping("aop")
public class AopController {
    @Autowired
    private ICalculatorService ICalculatorService;

    @GetMapping("/div")
    public Integer div(int a, int b){
        a = 6;
        b = 4;
        int div = ICalculatorService.div(a, b);
        return div;
    }

    @GetMapping("/mul")
    public Integer mul(int a, int b){
        a = 6;
        b = 4;
        int div = ICalculatorService.mul(a, b);
        return div;
    }
}
