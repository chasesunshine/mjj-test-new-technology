package org.dongfu.controller;

import com.alibaba.fastjson.JSON;
import org.dongfu.entity.CanalMysqlListener;
import org.dongfu.service.CanalMysqlListenerService;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/selectOne")
    public String selectOne() {
        CanalMysqlListener canalMysqlListener = canalMysqlListenerService.queryById(1);
        return JSON.toJSONString(canalMysqlListener);
    }

    @GetMapping("/insertOne")
    public String insertOne() {
        Integer rows = canalMysqlListenerService.insertData();
        return JSON.toJSONString(rows);
    }
}
