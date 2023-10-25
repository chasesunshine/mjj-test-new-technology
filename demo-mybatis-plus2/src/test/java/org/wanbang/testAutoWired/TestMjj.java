package org.wanbang.testAutoWired;


import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.wanbang.study.autowireDoc.Peopel;

@RunWith(SpringRunner.class)	//注意测试文件的位置 必须在主文件加载包路径下
@SpringBootTest
public class TestMjj {

    /**
     * 手动装配
     *
     * applicationContext.xml 这样的时候
     *     <bean id="cat" class="org.wanbang.study.autowireDoc.Cat"/>
     *     <bean id="dog" class="org.wanbang.study.autowireDoc.Dog"/>
     *     <bean id="people" class="org.wanbang.study.autowireDoc.Peopel">
     *         <property name="name" value="张三"/>
     *         <property name="cat" ref="cat"/>
     *         <property name="dog" ref="dog"/>
     *     </bean>
     * 结果： {"cat":{},"dog":{},"name":"张三"}
     *
     *
     * applicationContext.xml 这样的时候
     *    <bean id="people" class="org.wanbang.study.autowireDoc.Peopel">
     *         <property name="name" value="张三"/>
     *     </bean>
     *
     * 结果： {"name":"张三"}
     *
     */
    @Test
    public void Test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Peopel people = (Peopel)applicationContext.getBean("people");
        System.out.println(JSON.toJSONString(people));
    }


    /**
     * 通过xml文件实现自动装配 (1.byName)
     *     <bean id="cat" class="org.wanbang.study.autowireDoc.Cat"/>
     *     <bean id="dog" class="org.wanbang.study.autowireDoc.Dog"/>
     *     <bean id="people" class="org.wanbang.study.autowireDoc.Peopel" autowire="byName">
     *         <property name="name" value="张三"/>
     *     </bean>
     *
     * 结果：{"cat":{},"dog":{},"name":"张三"}
     *
     *
     * 通过xml文件实现自动装配 (1.byName)
     *     <bean id="cat" class="org.wanbang.study.autowireDoc.Cat"/>
     *     <bean id="dog" class="org.wanbang.study.autowireDoc.Dog"/>
     *     <bean id="people" class="org.wanbang.study.autowireDoc.Peopel" autowire="byType">
     *         <property name="name" value="张三"/>
     *     </bean>
     *
     * 结果：{"cat":{},"dog":{},"name":"张三"}
     */
    @Test
    public void Test2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Peopel people = (Peopel)applicationContext.getBean("people");
        System.out.println(JSON.toJSONString(people));
    }


    /**
     * 通过注解实现自动装配 Autowired注解【常用】
     *     <bean id="cat" class="org.wanbang.study.autowireDoc.Cat"/>
     *     <bean id="dog" class="org.wanbang.study.autowireDoc.Dog"/>
     *     <bean id="people" class="org.wanbang.study.autowireDoc.Peopel">
     *         <property name="name" value="张三"/>
     *     </bean>
     *
     * 结果：{"cat":{},"dog":{},"name":"张三"}
     */
    @Test
    public void Test3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Peopel people = (Peopel)applicationContext.getBean("people");
        System.out.println(JSON.toJSONString(people));
    }
}
