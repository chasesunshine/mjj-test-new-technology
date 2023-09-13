package org.dongfu.study.ioc.ioc10.bean;

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
 *  在 UserService 新修改了一个原有 UserDao 属性为 IUserDao，后面我们会给这个
 * 属性注入代理对象。
 *
 */
public class UserService{

    private String uId;
    private String company;
    private String location;
    private IUserDao userDao;
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

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }
}