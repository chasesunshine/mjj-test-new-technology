package org.wanbang.study.protecttest.B;

import org.wanbang.study.protecttest.A.test;

/**
* @description: TODO
* @author majiajian
* @date 2022/9/8 14:33
* @version 1.0
*/

public class test2_1 extends test{
    public static void main(String[] args) {
        /**
         * 2、对于不同包的父类与子类，只能通过自身实例(自身的引用)访问自身继承的实例方法，
         * 而不能通过父类实例(引用)访问父类的实例方法。
         */
        test aa = new test();
        test2_1 bb = new test2_1();
        //aa.SOUT();  //编译不通过，不能通过父类实例(引用)访问父类的实例方法。
        bb.SOUT();  //编译通过

        /**
         * 3、对于同父类的亲兄弟类，子类只能在自己的作用范围内，访问自己继承的那个父类的protected实例方法域，
         * 而无法到访问其他子类（同父类的亲兄弟类）所继承的protected实例方法域。
         */
        test2_2 cc = new test2_2();
        // cc.SOUT();		// 编译错误，因为这里的cc访问的是test2_2类的SOUT方法域，不行。
    }
}

class test2_2 extends test{
    public static void k(){
        test2_2 aa = new test2_2();
        aa.SOUT();		// 在这里访问就可以，因为访问的是本类的SOUT方法域。
    }
}