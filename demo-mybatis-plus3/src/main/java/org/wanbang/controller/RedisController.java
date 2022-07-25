package org.wanbang.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.wanbang.common.entity.Result;
import org.wanbang.entity.SpringWorld;
import org.wanbang.service.SpringWordService;
import org.wanbang.service.TestService;
import org.wanbang.util.redis.lock.LockExecutor;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @description: TODO
 * @author majiajian
 * @date 2022/6/22 16:14
 * @version 1.0
 */

@Component
@RestController
@RequestMapping("/redis")
public class RedisController {
    @Resource
    private SpringWordService springWordService;

//    @Resource
//    private LockExecutor lockExecutor;

    @GetMapping("/selectOne")
    public void  selectOne(){
//        try {
//            String mjj1 = lockExecutor.exec("Mjj:token", 3, () -> {
//                return "1";
//            });
//            System.out.println("1");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
