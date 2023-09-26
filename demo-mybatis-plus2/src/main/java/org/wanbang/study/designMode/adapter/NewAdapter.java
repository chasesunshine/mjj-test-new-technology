package org.wanbang.study.designMode.adapter;

// 符合新的调用规则的老类适配器
public class NewAdapter implements NewAction{//如果新类是没有基类的,可以直接继承新类

    private OldActionA a = null;
    public NewAdapter(OldActionA a){
        this.a = a;
    }
    public void run() {
        a.start();
    }

}
