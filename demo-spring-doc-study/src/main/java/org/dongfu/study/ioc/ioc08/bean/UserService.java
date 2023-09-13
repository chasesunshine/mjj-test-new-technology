package org.dongfu.study.ioc.ioc08.bean;

import org.dongfu.study.ioc.ioc08.factory.DisposableBean;
import org.dongfu.study.ioc.ioc08.factory.InitializingBean;

/**
 * @description: TODO
 * @author majiajian
 * @date 2022/9/24 16:24
 * @version 1.0
 */

/**
 *
 *  UserService，以实现接口 InitializingBean, DisposableBean 的两个方法 destroy()、
 * afterPropertiesSet()，处理相应的初始化和销毁方法的动作。afterPropertiesSet，方
 * 法名字很好，在属性设置后执行
 *
 */
public class UserService implements InitializingBean, DisposableBean {
    private String uId;
    private String company;
    private String location;
    private UserDao userDao;

    @Override
    public void destroy() throws Exception {
        System.out.println("执行：UserService.destroy");
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行：UserService.afterPropertiesSet");
    }


    public String queryUserInfo() {
        return userDao.queryUserName(uId) + "," + company + "," + location;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}