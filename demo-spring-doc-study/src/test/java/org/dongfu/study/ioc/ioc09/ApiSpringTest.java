package org.dongfu.study.ioc.ioc09;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.dongfu.study.ioc.ioc09.bean.UserService;
import org.dongfu.study.ioc.ioc09.context.support.ClassPathXmlApplicationContext;

/**
 *  从测试结果可以看到，本章节新增加的感知接口对应的具体实现(BeanNameAware,
 * BeanClassLoaderAware, ApplicationContextAware, BeanFactoryAware)，已经可以如
 * 期输出结果了。
 */
@RunWith(SpringRunner.class)	//注意测试文件的位置 必须在主文件加载包路径下
@SpringBootTest
public class ApiSpringTest {
    @Test
    public void test_ioc08() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:study/spring09.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取 Bean 对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
        System.out.println("ApplicationContextAware： "+userService.getApplicationContext());
        System.out.println("BeanFactoryAware："+userService.getBeanFactory());
    }

}
