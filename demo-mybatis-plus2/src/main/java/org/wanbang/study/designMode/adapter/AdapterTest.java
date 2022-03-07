package org.wanbang.study.designMode.adapter;

public class AdapterTest {
    public static void main(String[] args) {
        NewClient client = new NewClient();//创建新的调用器
        NewActionB newB = new NewActionB();//符合新调用器规则的类
        client.userDo(newB);//调用器调用

        System.out.println("-------------------------");

        OldActionA oldA = new OldActionA();//不符合新调用器规则的类
        NewAdapter newA = new NewAdapter(oldA);//能够对不符合调用器规则的类进行适配的适配器
        client.userDo(newA);//调用器调用
    }
}
