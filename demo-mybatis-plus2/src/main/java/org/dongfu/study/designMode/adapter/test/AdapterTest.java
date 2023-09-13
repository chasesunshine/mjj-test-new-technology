package org.dongfu.study.designMode.adapter.test;

import org.dongfu.study.designMode.adapter.NewActionB;
import org.dongfu.study.designMode.adapter.NewAdapter;
import org.dongfu.study.designMode.adapter.NewClient;
import org.dongfu.study.designMode.adapter.OldActionA;

public class AdapterTest {
    public static void main(String[] args) {
        NewClient client = new NewClient();//创建新的调用器
        NewActionB newB = new NewActionB();//符合新调用器规则的类

        // 这里走下去 有三个 类实现它 NewAction NewBction 和 OldActionA
        // 但是为什么精确找到 NewActionB 并执行代码
        client.userDo(newB);//调用器调用

        System.out.println("-------------------------");

        OldActionA oldA = new OldActionA();//不符合新调用器规则的类
        NewAdapter newA = new NewAdapter(oldA);//能够对不符合调用器规则的类进行适配的适配器
        client.userDo(newA);//调用器调用
    }
}
