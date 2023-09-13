package org.dongfu.study.threadLocal.ThreadLocalTest1;

public class TestClient implements Runnable {
    private ThreadLocalUtil sn;

    public TestClient(ThreadLocalUtil sn) {
        super();
        this.sn = sn;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            // ④每个线程打出3个序列值
            System.out.println("thread[" + Thread.currentThread().getName() + "] sn[" + sn.getNextNum() + "]");
        }
    }

    public static void main(String[] args) {
        ThreadLocalUtil sn = new ThreadLocalUtil();
        // ③ 3个线程共享sn，各自产生序列号
        TestClient t1 = new TestClient(sn);
        TestClient t2 = new TestClient(sn);
        TestClient t3 = new TestClient(sn);
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
    }
}
