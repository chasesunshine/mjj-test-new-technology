package org.dongfu.study.ioc.ioc04;

import org.dongfu.study.ioc.ioc04.bean.UserService;
import org.dongfu.study.ioc.ioc04.exception.BeansException;
import org.dongfu.study.ioc.ioc04.factory.config.BeanDefinition;
import org.dongfu.study.ioc.ioc04.factory.support.DefaultListableBeanFactory;

/**
 * @description: TODO
 * @author majiajian
 * @date 2022/9/7 18:18
 * @version 1.0
 */

/**
 *  在此次的单元测试中除了包括；Bean 工厂、注册 Bean、获取 Bean，三个步骤，
 *  还额外增加了一次对象的获取和调用。这里主要测试验证单例对象的是否正确的存
 *  放到了缓存中。
 *  此外与上一章节测试过程中不同的是，我们把 UserService.class 传递给了
 *  BeanDefinition 而不是像上一章节那样直接 new UserService() 操作。
 */
public class ApiTest {
    public static void main(String[] args) throws BeansException {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 注入 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3. 第一次获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService", "小傅哥");
        userService.queryUserInfo();

        // 第二次获取 bean
        UserService userService1 = (UserService) beanFactory.getBean("userService", "小马哥");
        userService1.queryUserInfo();
    }
}
