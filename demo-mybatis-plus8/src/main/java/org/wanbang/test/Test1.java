package org.wanbang.test;

public abstract class Test1 {
    public Test1(){
        System.out.println("parent constructor");
    }
    protected void execute(){
        System.out.println("execute parent");
    }
}
