package org.wanbang.study.ioc.ioc09.bean;

import org.wanbang.study.ioc.ioc09.context.ApplicationContext;
import org.wanbang.study.ioc.ioc09.context.ApplicationContextAware;
import org.wanbang.study.ioc.ioc09.exception.BeansException;
import org.wanbang.study.ioc.ioc09.factory.*;

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
public class UserService implements BeanNameAware, BeanClassLoaderAware, ApplicationContextAware, BeanFactoryAware {

    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

    private String uId;
    private String company;
    private String location;
    private UserDao userDao;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean Name is：" + name);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("ClassLoader：" + classLoader);
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


    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

}