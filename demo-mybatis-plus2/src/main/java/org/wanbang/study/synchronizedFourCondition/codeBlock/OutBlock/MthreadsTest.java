package org.wanbang.study.synchronizedFourCondition.codeBlock.OutBlock;

public class MthreadsTest {
    public static void main(String[] args) {
        System.out.println("使用关键字synchronized");
        Mthreads mt=new Mthreads();
        Thread thread1 = new Thread(mt, "mt1");
        Thread thread2 = new Thread(mt, "mt2");
        thread1.start();
        thread2.start();
    }
}
