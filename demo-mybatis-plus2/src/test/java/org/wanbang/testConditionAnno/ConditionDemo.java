package org.wanbang.testConditionAnno;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.wanbang.study.ConditionAnno.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConditionDemo {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void run(){
        User user = (User) applicationContext.getBean("pi");
        System.out.println("用户名"+user.getName()+"年龄"+user.getAge());
    }
}

