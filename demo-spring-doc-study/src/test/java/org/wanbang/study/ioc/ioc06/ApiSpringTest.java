package org.wanbang.study.ioc.ioc06;

import cn.hutool.core.io.IoUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wanbang.study.ioc.ioc06.bean.UserService;
import org.wanbang.study.ioc.ioc06.core.io.DefaultResourceLoader;
import org.wanbang.study.ioc.ioc06.core.io.Resource;
import org.wanbang.study.ioc.ioc06.exception.BeansException;
import org.wanbang.study.ioc.ioc06.factory.support.DefaultListableBeanFactory;
import org.wanbang.study.ioc.ioc06.factory.support2.XmlBeanDefinitionReader;

import java.io.IOException;
import java.io.InputStream;

/**
 * @description: TODO
 * @author majiajian
 * @date 2022/9/7 18:18
 * @version 1.0
 */
@RunWith(SpringRunner.class)	//注意测试文件的位置 必须在主文件加载包路径下
@SpringBootTest
public class ApiSpringTest {

    @Test
    public void testIoc06() throws BeansException {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册 Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:study/spring06.xml");

        // 3. 获取 Bean 对象调用方法
        UserService userService = (UserService) beanFactory.getBean("userService");
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

}
