package org.wanbang.study.designMode.adapter;

// 新的调用规则
public class NewClient {
    public void userDo(NewAction action){
        Class<? extends NewAction> aClass = action.getClass();
        String simpleName = action.getClass().getSimpleName();
        action.run();
    }
}
