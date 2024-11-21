package org.wanbang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wanbang.dao.BookDao;
import org.wanbang.dao.UserDao;
import org.wanbang.entity.Book;
import org.wanbang.entity.User;
import org.wanbang.service.BookService;
import org.wanbang.service.UserService;

import javax.annotation.Resource;

/**
 * (SpringWord)表服务实现类
 *
 * @author makejava
 * @since 2022-06-16 10:17:43
 */
@Slf4j
@Service
public class BookServiceImpl implements BookService {
    @Resource
    private BookDao bookDao;

    @Transactional
    @Override
    public Integer delete() {
        int delete = bookDao.delete(new QueryWrapper<Book>().lambda().eq(Book::getId, 1));
        return delete;
    }
}
