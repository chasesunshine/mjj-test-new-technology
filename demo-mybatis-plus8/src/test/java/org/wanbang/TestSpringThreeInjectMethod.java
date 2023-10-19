package org.wanbang;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.wanbang.springthreeInjectmethod.constructor.service.impl.UserServiceConstructor;
import org.wanbang.springthreeInjectmethod.setter.service.impl.UserServiceSetter;

@RunWith(SpringRunner.class)	//注意测试文件的位置 必须在主文件加载包路径下
@SpringBootTest
public class TestSpringThreeInjectMethod {

    @Test
    public void testDIConstructor() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-constructor.xml");
        // 获取bean对象
        UserServiceConstructor userService = ac.getBean(UserServiceConstructor.class, "userService");
        // 模拟用户登录
        userService.loginUser();
    }

    @Test
    public void testDISetter() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext-setter.xml");
        // 获取bean对象
        UserServiceSetter userService = ac.getBean(UserServiceSetter.class, "userService");
        // 模拟用户登录
        userService.loginUser();
    }
}
