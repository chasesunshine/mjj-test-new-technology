package com.example.demo.springbootdemo.controller;


import com.example.demo.springbootdemo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 测试Controller
 *
 * @author zhao
 * @date 2019.3.8
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    //返回数据
    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    @ResponseBody
    public String test1(HttpServletRequest request) {
        System.out.println(request.getRequestURI()); // /demo/test1
        return "返回数据";
    }


    //返回页面
    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public String test2(HttpServletRequest request) {
        System.out.println(request.getRequestURI()); // /demo/test2
        return "test";
    }

    //返回对象
    @RequestMapping(value = "/test3", method = RequestMethod.GET)
    @ResponseBody
    public User test3(HttpServletRequest request) {
        System.out.println(request.getRequestURI()); // /demo/test3
        User user = new User();
        user.setId(1);
        user.setName("admin");
        return user;
    }


}