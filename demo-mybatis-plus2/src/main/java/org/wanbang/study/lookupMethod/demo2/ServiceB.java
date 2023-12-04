package org.wanbang.study.lookupMethod.demo2;

public class ServiceB {
    private ServiceA serviceA;
    public void say() {
        serviceA = this.getServiceA();
        System.out.println("this:" + this + ",serviceA:" + serviceA);
    }

    public ServiceA getServiceA() { //@1
        return null;
    }

}
