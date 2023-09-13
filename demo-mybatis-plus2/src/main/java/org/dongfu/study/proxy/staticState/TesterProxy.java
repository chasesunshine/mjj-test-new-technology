package org.dongfu.study.proxy.staticState;

import org.dongfu.study.proxy.common.ITester;

public class TesterProxy implements ITester {
    private ITester tester;
    public TesterProxy(ITester tester){
        this.tester = tester;
    }

    @Override
    public void doTesting() {
        System.out.println("Tester is preparing test documentation...");
        tester.doTesting();
    }
}
