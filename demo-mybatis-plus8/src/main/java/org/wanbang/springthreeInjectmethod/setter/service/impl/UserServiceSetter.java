package org.wanbang.springthreeInjectmethod.setter.service.impl;

import org.wanbang.springthreeInjectmethod.setter.dao.IUserDao;
import org.wanbang.springthreeInjectmethod.setter.service.IUserService;

public class UserServiceSetter implements IUserService {

    private IUserDao userDao1;

    public void setUserDao(IUserDao userDao1) {
        this.userDao1 = userDao1;
    }

    public void loginUser() {
        userDao1.loginUser();
    }

}
