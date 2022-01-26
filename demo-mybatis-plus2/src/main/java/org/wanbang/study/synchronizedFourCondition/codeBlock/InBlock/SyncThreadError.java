package org.wanbang.study.synchronizedFourCondition.codeBlock.InBlock;

class SyncThreadError implements Runnable {
    private static int count;
    public SyncThreadError() {
        count = 0;
    }
    public  void run() {
        //synchronized (this){
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println("线程名:"+Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        //}
    }
    public int getCount() {
        return count;
    }
}