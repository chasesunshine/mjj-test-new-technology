package com.dongfu.controller;

import com.dongfu.service.CanalMysqlListenerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jjh
 * @since 2022-11-18
 */
@RestController
@RequestMapping("/user")
public class CanalMysqlListenerController {
    @Resource
    private CanalMysqlListenerService canalMysqlListenerService;

}
