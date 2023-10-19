package org.wanbang.springthreeInjectmethod.constructor.service.impl;

import org.wanbang.springthreeInjectmethod.constructor.dao.IUserDao;
import org.wanbang.springthreeInjectmethod.constructor.service.IUserService;

public class UserServiceConstructor implements IUserService {

    private IUserDao userDao;

    public UserServiceConstructor(IUserDao userDao) {
        this.userDao = userDao;
    }

    public void loginUser() {
        userDao.loginUser();
    }

}
