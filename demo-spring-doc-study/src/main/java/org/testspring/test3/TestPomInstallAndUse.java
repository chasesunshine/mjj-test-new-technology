package org.testspring.test3;

import org.wanbang.entity.TestUser1;

public class TestPomInstallAndUse {
    public static void main(String[] args) {
        TestUser1 testUser1 = new TestUser1();
        Long id = testUser1.getId();
        System.out.println(id);
    }
}
