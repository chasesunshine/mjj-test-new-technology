package org.dongfu.study.ioc.ioc05;

import org.dongfu.study.ioc.ioc05.bean.UserService;
import org.dongfu.study.ioc.ioc05.exception.BeansException;
import org.dongfu.study.ioc.ioc05.factory.config.BeanDefinition;
import org.dongfu.study.ioc.ioc05.factory.config.BeanReference;
import org.dongfu.study.ioc.ioc05.factory.support.DefaultListableBeanFactory;
import org.dongfu.study.ioc.ioc05.bean.UserDao;
import org.dongfu.study.ioc.ioc05.entity.PropertyValue;
import org.dongfu.study.ioc.ioc05.entity.PropertyValues;

/**
 * @description: TODO
 * @author majiajian
 * @date 2022/9/7 18:18
 * @version 1.0
 */

/**
 *  与直接获取 Bean 对象不同，这次我们还需要先把 userDao 注入到 Bean 容器
 * 中。beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));
 *  接下来就是属性填充的操作了，一种是普通属性 new
 * PropertyValue("uId", "10001")，另外一种是对象属性 new
 * PropertyValue("userDao",new BeanReference("userDao"))
 *  接下来的操作就简单了，只不过是正常获取 userService 对象，调用方法即可。
 */
public class ApiTest {
    public static void main(String[] args) throws BeansException {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. UserDao 注册
        beanFactory.registerBeanDefinition( "userDao", new BeanDefinition(UserDao.class) );

        // 3. UserService 设置属性[uId、userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

        // 4. UserService 注入 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 5. UserService 获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

    }
}
