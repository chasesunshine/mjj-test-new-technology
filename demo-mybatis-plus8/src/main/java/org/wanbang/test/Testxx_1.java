package org.wanbang.test;

public abstract class Testxx_1 extends Testxx{
    public Testxx_1(){
        System.out.println("son constructor");
    }
    protected void execute(){
        System.out.println("execute son");
    }

    private void executeMethod(){
        System.out.println("execute son");
    }
}
