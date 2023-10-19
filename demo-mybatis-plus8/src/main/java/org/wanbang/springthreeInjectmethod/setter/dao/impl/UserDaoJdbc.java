package org.wanbang.springthreeInjectmethod.setter.dao.impl;

import org.wanbang.springthreeInjectmethod.setter.dao.IUserDao;

public class UserDaoJdbc implements IUserDao {
    @Override
    public void loginUser() {
        System.out.println("Spring常用的三种注入方式 - setter注入 ");
    }
}
