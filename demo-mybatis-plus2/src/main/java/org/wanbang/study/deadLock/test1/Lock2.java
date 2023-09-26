package org.wanbang.study.deadLock.test1;

public class Lock2 implements Runnable{
    @Override
    public void run(){
        try{
            System.out.println("Lock2 running");
            while(true){
                synchronized(DeadLockTestError.obj2){
                    System.out.println("Lock2 lock obj2");
                    Thread.sleep(3000);
                    synchronized(DeadLockTestError.obj1){
                        System.out.println("Lock2 lock obj1");
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

