package org.wanbang.study.lookupMethod.demo2;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 上面这种方式实现了单例bean中使用多例bean的需求，但是用到spring中的接口ApplicationContextAware，此时对spring的api有耦合的作用，我们一直推行高内聚低耦合，所以我们得寻求更好的办法。
 * 能不能有这样的功能，当serviceB中调用getServiceA的时候，系统自动将这个方法拦截，然后去spring容器中查找对应的serviceA对象然后返回，spring中的lookup-method就可以实现这样的功能。
 *
 * 注意最后2行的输出，serviceA是调用this.getServiceA()方法获取 ，源码中这个方法返回的是null，但是spring内部对这个方法进行了拦截，每次调用这个方法的时候，都会去容器中查找serviceA，然后返回，所以上面最后2行的输出中serviceA是有值的，并且是不同的serviceA实例。
 * lookup-method：看其名字，就知道意思：方法查找，调用name属性指定的方法的时候，spring会对这个方法进行拦截，然后去容器中查找lookup-method元素中bean属性指定的bean，然后将找到的bean作为方法的返回值返回。
 * 这个地方底层是使用cglib代理实现的，后面有篇文章会详细介绍代理的2种实现，到时候大家注意下，spring中很多牛逼的功能都是靠代理实现的。
 */
public class NormalBeanTest {

    @Test
    public void lookupmethod() {
        String beanXml = "lookupmethod.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);

        System.out.println(context.getBean(ServiceA.class)); //@1
        System.out.println(context.getBean(ServiceA.class)); //@2

        System.out.println("serviceB中的serviceA");
        ServiceB serviceB = context.getBean(ServiceB.class); //@3
        serviceB.say();
        serviceB.say();
    }
}