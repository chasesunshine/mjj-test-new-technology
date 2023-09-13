package org.dongfu.study.allDesignMode.constructMode.proxyMode;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.dongfu.study.allDesignMode.constructMode.proxyMode.dao.IUserDao;

/**
* @description: TODO
* @author majiajian
* @date 2022/8/17 18:39
* @version 1.0
*/

public class Test {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        IUserDao userDao = beanFactory.getBean("userDao", IUserDao.class);
        String res = userDao.queryUserInfo("100001");
        System.out.println("测试结果：" + res);
    }
}
