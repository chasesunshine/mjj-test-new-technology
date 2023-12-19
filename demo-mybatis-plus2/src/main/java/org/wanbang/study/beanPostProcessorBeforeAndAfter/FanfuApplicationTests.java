package org.wanbang.study.beanPostProcessorBeforeAndAfter;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
@Slf4j
public class FanfuApplicationTests {
   @Test
    public void test3(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.wanbang");
        Dog1 dog = ((Dog1) context.getBean("dog1"));
        log.info(dog.getName());
    }
}
