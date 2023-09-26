package org.wanbang.controller;
/**
* @description: TODO
* @author majiajian
* @date 2022/8/25 14:37
* @version 1.0
*/

import com.alibaba.fastjson.JSON;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wanbang.entity.SpringWorld;
import org.wanbang.service.SpringWordService;

import javax.annotation.Resource;

/**
 *
 * 事务失效的几个原因(看这篇文章)
 * https://blog.csdn.net/qq_45682433/article/details/115941815
 *
 * @Transactional失效——同一个类中方法调用导致，解决方案！（再看这篇文章）
 * https://blog.csdn.net/zhangkaixuan456/article/details/109082645
 */

/**
 * 测试 调用本类方法 事务失效问题
 */
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@RestController
@RequestMapping("/transactional")
public class TransactionalController {
    @Resource
    private SpringWordService springWordService;

    @GetMapping("/updateOne")
    public String updateOne() {
        SpringWorld springWorld = springWordService.updateOne((long) 1);
        return JSON.toJSONString(springWorld);
    }

    @GetMapping("/updateTwo")
    public String updateTwo() {
        SpringWorld springWorld = springWordService.updateTwo((long) 2);
        return JSON.toJSONString(springWorld);
    }


}
