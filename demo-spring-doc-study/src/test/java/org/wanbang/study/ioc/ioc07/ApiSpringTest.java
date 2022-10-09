package org.wanbang.study.ioc.ioc07;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wanbang.study.ioc.ioc07.bean.UserService;
import org.wanbang.study.ioc.ioc07.exception.BeansException;
import org.wanbang.study.ioc.ioc07.factory.ConfigurableListableBeanFactory;
import org.wanbang.study.ioc.ioc07.factory.support.DefaultListableBeanFactory;
import org.wanbang.study.ioc.ioc07.factory.support2.XmlBeanDefinitionReader;
import org.wanbang.study.ioc.ioc07.test.MyBeanFactoryPostProcessor;
import org.wanbang.study.ioc.ioc07.test.MyBeanPostProcessor;

@RunWith(SpringRunner.class)	//注意测试文件的位置 必须在主文件加载包路径下
@SpringBootTest
public class ApiSpringTest {
    @Test
    public void test_BeanFactoryPostProcessorAndBeanPostProcessor() throws BeansException {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2. 读取配置文件&注册 Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");
        // 3. BeanDefinition 加载完成 & Bean 实例化之前，修改 BeanDefinition 的属性值
        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory((ConfigurableListableBeanFactory) beanFactory);
        // 4. Bean 实例化之后，修改 Bean 属性信息
        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);
        // 5. 获取 Bean 对象调用方法
        UserService userService = (UserService) beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }
}
