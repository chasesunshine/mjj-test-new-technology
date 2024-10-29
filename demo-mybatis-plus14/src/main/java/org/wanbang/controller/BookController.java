package org.wanbang.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wanbang.entity.User;
import org.wanbang.service.BookService;
import org.wanbang.service.UserService;

import javax.annotation.Resource;

/**
 * (SpringWord)表控制层
 *
 * @author makejava
 * @since 2022-06-16 10:17:35
 */
@Slf4j
@RestController
@RequestMapping("springWordTest14")
public class BookController {
    @Resource
    private BookService bookService;

    @GetMapping("/delete")
    public Integer selectOne() {
        Integer count = bookService.delete();
        return count;
    }

}

