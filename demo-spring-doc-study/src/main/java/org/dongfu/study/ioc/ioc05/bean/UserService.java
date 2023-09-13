package org.dongfu.study.ioc.ioc05.bean;

import lombok.Data;

/**
 * @description: TODO
 * @author majiajian
 * @date 2022/9/24 16:24
 * @version 1.0
 */

@Data
public class UserService {
    private String uId;
    private UserDao userDao;
    public void queryUserInfo() {
        System.out.println("查询用户信息：" + userDao.queryUserName(uId));
    }
    // ...get/se
}
