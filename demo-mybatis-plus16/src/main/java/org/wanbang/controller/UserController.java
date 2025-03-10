package org.wanbang.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wanbang.entity.User;
import org.wanbang.param.RequestParam;
import org.wanbang.service.UserService;
import org.wanbang.util.raft.RaftRateLimiter;
import org.wanbang.util.raft.RateLimitedRaftRequestHandler2;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SpringWord)表控制层
 *
 * @author makejava
 * @since 2022-06-16 10:17:35
 */
@Slf4j
@RestController
@RequestMapping("springWordTest10")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/selectOne")
    public String selectOne() {
        User user = userService.queryById("1");
        return JSON.toJSONString(user);
    }

    @GetMapping("/selectData")
    public List<User> selectData() {
        List<User> user = userService.selectData(1,3);
        return user;
    }


    @GetMapping("/selectTwo")
    public String selectTwo() throws InterruptedException {
        RateLimitedRaftRequestHandler2 handler = new RateLimitedRaftRequestHandler2();

        for (int i = 0; i < 5; i++) {
            Thread.sleep(200); // 模拟不同步到达的请求
            RequestParam requestParam = new RequestParam();
            String value = String.valueOf(i);
            if(i == 3 ){
                requestParam.setGroup("2").setName(value).setId(i).setSex(value).setAge(i).setPassword(value);
            }else {
                requestParam.setGroup("1").setName(value).setId(i).setSex(value).setAge(i).setPassword(value);
            }
            handler.submitRequest(requestParam);
        }

        // 让程序运行足够长的时间以观察结果
        Thread.sleep(5000);
        handler.scheduler.shutdown();

        return null;
    }

    @GetMapping("/selectThree")
    public void selectThree() throws InterruptedException {
        RaftRateLimiter rateLimiter = new RaftRateLimiter();

        // 模拟快速发送多个请求
        for (int i = 0; i < 5; i++) {
            if(i == 1){
                rateLimiter.addRequest("devicekey1", "request-" + i);
            }else if(i == 2){
                rateLimiter.addRequest("devicekey2", "request-" + i);
            }else if(i == 4){
                rateLimiter.addRequest("devicekey4", "request-" + i);
            }
            Thread.sleep(200); // 等待200ms发送下一个请求
        }

        // 让程序运行足够长的时间以确保所有请求都被处理
        Thread.sleep(3000);
//        System.exit(0);
    }

}

