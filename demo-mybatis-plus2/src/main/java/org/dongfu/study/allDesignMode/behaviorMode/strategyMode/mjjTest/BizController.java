package org.dongfu.study.allDesignMode.behaviorMode.strategyMode.mjjTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 模拟一次http调用
 */
@RestController
public class BizController {

    @Autowired
    private BizService bizService;

    @PostMapping("/v1/biz/testMuti")
    public String test1(String order, Integer level) {
        return bizService.getCheckResultComX(order, level);
    }
}
