package org.dongfu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.dongfu.service.PayService;

@RestController
public class PayController {
    @Autowired
    private PayService payService;

    @GetMapping("/retry")
    public String getNum() throws Exception {
        int i = payService.minGoodsnum(-1);
        System.out.println("===="+i);
        return "succeess";
    }
}