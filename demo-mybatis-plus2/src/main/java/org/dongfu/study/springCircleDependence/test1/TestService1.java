package org.dongfu.study.springCircleDependence.test1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TestService1 {
    @Autowired
    private TestService2 testService2;

    // 使用构造方法注入 - 循环依赖
//    public TestService1(TestService2 testService2) {
//         this.testService2 = testService2;
//    }

    public void test1() {
        System.out.println("ThreadLocalDisruptor");
    }
}
