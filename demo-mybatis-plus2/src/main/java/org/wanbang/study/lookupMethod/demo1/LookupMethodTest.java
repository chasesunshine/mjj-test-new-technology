package org.wanbang.study.lookupMethod.demo1;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 从输出中可以看出，@1和@2输出了不同的ServiceA，而@4和@5输出的是同一个serviceA，这是因为serviceB是单例的，serviceB中的serviceA会在容器创建serviceB的时候，从容器中获取一个serviceA将其注入到serviceB中，所以自始至终serviceB中的serviceA都是同一个对象。
 * 如果我们希望beanB中每次使用beanA的时候beanA都是一个新的实例，我们怎么实现呢？
 * 我们可以在serviceB中加个方法去获取serviceA，这个方法中我们主动去容器中获取serviceA，那么每次获取到的都是不同的serviceA实例。
 */
public class LookupMethodTest {

    @Test
    public void normalBean() {
        String beanXml = "normalBean.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);

        System.out.println(context.getBean(ServiceA.class)); //@1
        System.out.println(context.getBean(ServiceA.class)); //@2

        System.out.println("serviceB中的serviceA");
        ServiceB serviceB = context.getBean(ServiceB.class); //@3
        System.out.println(serviceB.getServiceA()); //@4
        System.out.println(serviceB.getServiceA()); //@5
    }
}