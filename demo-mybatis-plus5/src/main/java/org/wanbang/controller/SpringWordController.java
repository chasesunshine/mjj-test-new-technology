package org.wanbang.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.wanbang.dto.Addr;
import org.wanbang.dto.User;
import org.wanbang.dto.UserDTO;
import org.wanbang.dto.response.ResponseData;
import org.wanbang.entity.SpringWorld;
import org.wanbang.service.SpringWordService;

import javax.annotation.Resource;
import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * (SpringWord)表控制层
 *
 * @author makejava
 * @since 2022-06-16 10:17:35
 */
@Slf4j
@RestController
@RequestMapping("springWordTest5")
public class SpringWordController {
    @Resource
    private SpringWordService springWordService;

    @GetMapping("/selectOne")
    public String selectOne() {
        SpringWorld springWorld = springWordService.queryById((long) 1);
        return JSON.toJSONString(springWorld);
    }

    @GetMapping("/{id}")
    public ResponseData<UserDTO> detail(@PathVariable Long id) {
        Preconditions.checkNotNull(id, "id is null");

        log.info("user id:{}", id);

        UserDTO userDTO = new UserDTO();
        userDTO.setId(id);
        userDTO.setAge(20);
        userDTO.setUsername("加班写Bug");

        return ResponseData.success(userDTO);
    }


    @GetMapping("/selectTwo")
    public String selectTwo(@RequestParam("name") String name) {
        log.info("name {}", name);
//        SpringWorld springWorld = springWordService.queryById((long) 1);
        return JSON.toJSONString(name);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // 注册一个自定义的编辑器，将所有传入的字符串转换为大写
        binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(text.toUpperCase());
            }
        });

        // 注册一个自定义的编辑器，将所有传入的日期格式化为 yyyy/MM/dd 格式
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy/MM/dd"), true));
    }

//    @ModelAttribute("user")
//    public User addAccount() {
//        return new User(3L,"jz",18);
//    }

    @PostMapping("/selectThree")
    public String selectThree(@ModelAttribute("user") User user,@ModelAttribute("addr") Addr addr) {
        System.out.println(user);
        System.out.println(addr);
//        SpringWorld springWorld = springWordService.queryById((long) 1);
        return JSON.toJSONString(user);
    }

    @PostMapping("/selectFour")
    @ResponseBody
    public String selectFour(@RequestBody User user) {
        System.out.println(user);
//        SpringWorld springWorld = springWordService.queryById((long) 1);
        return JSON.toJSONString(user);
    }

    @InitBinder("user")
    public void initBinderUser(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("userBinder.");
    }

    @InitBinder("addr")
    public void initBinderAddr(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("addrBinder.");
    }

}

