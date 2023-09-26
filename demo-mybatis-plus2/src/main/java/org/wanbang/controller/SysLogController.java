package org.wanbang.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wanbang.service.SysLogService;

@Slf4j
@RestController
@RequestMapping("sys/log")
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;

    @GetMapping("/selectOne")
    public String  selectOne(){
        String s = sysLogService.selectOne();
        log.info("获取资料 : "+s);
        return s;
    }
}
