package org.wanbang.test;

public class Test {
    public interface Test2{
        public String info();
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2() {
            @Override
            public String info() {
                return "ceshi";
            }
        };
    }
}
