package org.wanbang.springthreeInjectmethod.constructor.dao.impl;

import org.wanbang.springthreeInjectmethod.constructor.dao.IUserDao;

public class UserDaoJdbc implements IUserDao {
    @Override
    public void loginUser() {
        System.out.println("Spring常用的三种注入方式 - 构造器注入 ");
    }
}
