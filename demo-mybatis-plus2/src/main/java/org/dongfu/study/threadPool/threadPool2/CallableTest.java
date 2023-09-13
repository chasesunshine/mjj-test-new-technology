package org.dongfu.study.threadPool.threadPool2;

import java.util.concurrent.Callable;

class CallableTest implements Callable {
    private String name;
    public CallableTest(String name){
        this.name = name;
    }
    @Override
    public Object call() throws Exception {
        System.out.println("调用Callable的call()方法进行逻辑处理开始！");
        return name;//call()方法执行完后返回的数据
    }
}