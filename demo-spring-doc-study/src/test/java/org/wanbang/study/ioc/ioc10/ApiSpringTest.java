package org.wanbang.study.ioc.ioc10;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wanbang.study.ioc.ioc09.bean.UserService;
import org.wanbang.study.ioc.ioc09.context.support.ClassPathXmlApplicationContext;
import org.openjdk.jol.info.ClassLayout;

/**
 *  在 spring.xml 配置文件中，设置了 scope="prototype" 这样就每次获取到的对象
 * 都应该是一个新的对象。
 *  这里判断对象是否为一个会看到打印的类对象的哈希值，所以我们把十六进制哈希
 * 打印出来。
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
        UserService userService01 = applicationContext.getBean("userService", UserService.class);
        UserService userService02 = applicationContext.getBean("userService", UserService.class);
        // 3. 配置 scope="prototype/singleton"
        System.out.println(userService01);
        System.out.println(userService02);
        // 4. 打印十六进制哈希
        System.out.println(userService01 + " 十六进制哈希：" + Integer.toHexString(userService01.hashCode()));
        System.out.println(ClassLayout.parseInstance(userService01).toPrintable());

    }

    /**
     *  关于 FactoryBean 的调用并没有太多不一样，因为所有的不同都已经被
     * spring.xml 配置进去了。当然你可以直接调用 spring.xml 配置的对象
     * cn.bugstack.springframework.test.bean.ProxyBeanFactory
     */
    @Test
    public void test_factory_bean() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:study/spring09.xml");
        applicationContext.registerShutdownHook();
        // 2. 调用代理方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }

}
