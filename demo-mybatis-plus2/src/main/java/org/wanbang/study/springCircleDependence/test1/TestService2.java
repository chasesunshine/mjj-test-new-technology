package org.wanbang.study.springCircleDependence.test1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService2 {
    @Autowired
    private TestService1 testService1;

    public TestService2(TestService1 testService1) {
        this.testService1 = testService1;
    }

    public void test2() {
        System.out.println("test2");
    }
}

