package org.wanbang.study.autowireDoc.test1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class Dog {
    public Dog(){
        System.out.println("执行 dog构造方法");
    }

//    @Bean
//    public Dog getTestDog(){
//        return new Dog();
//    }

    public void shout(){
        System.out.println("wang wang~");
    }
}
