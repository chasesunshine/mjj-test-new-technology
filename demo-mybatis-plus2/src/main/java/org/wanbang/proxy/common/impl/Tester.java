package org.wanbang.proxy.common.impl;

import org.wanbang.proxy.common.ITester;

public class Tester implements ITester {
    private String name;
    public Tester(String name){
        this.name = name;
    }
    @Override
    public void doTesting() {
        System.out.println("Tester " + name + " is testing code");
    }
}