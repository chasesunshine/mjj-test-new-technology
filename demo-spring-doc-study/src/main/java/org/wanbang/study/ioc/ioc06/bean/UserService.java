package org.wanbang.study.ioc.ioc06.bean;

import lombok.Data;

/**
 * @description: TODO
 * @author majiajian
 * @date 2022/9/24 16:24
 * @version 1.0
 */

public class UserService {
    private String uId;
    private UserDao userDao;

    public String queryUserInfo() {
        return userDao.queryUserName(uId);
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
