package org.wanbang.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.wanbang.dto.UserReq;
import org.wanbang.dto.UserReq1;
import org.wanbang.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/selectOne")
    public String  selectOne(){
        String s = userService.selectOne();
        return s;
    }

    @PostMapping("/vaild1")
    public String addStudent(@Valid @RequestBody UserReq user) {
        return "Student Created";
    }

    // 也可以手动来处理错误，加上一个BindingResult来接收验证结果即可：
    @PostMapping("/vaild2")
    public String addStudent(@Valid @RequestBody UserReq user, BindingResult validateResult) {
        if (validateResult.hasErrors()) {
            return validateResult.getAllErrors().get(0).getDefaultMessage();
        }
        return "Student Created";
    }

    /**
     * 参数校验
     *
     * @param user
     * @return
     */
    @PostMapping("/vaild3")
    public String addStudent(@Validated @RequestBody UserReq1 user) {
        return "Student Created1";
    }

}
