package org.wanbang.study.zixuanLock;

import java.util.concurrent.atomic.AtomicBoolean;

public class SpinLock {
    // 锁的状态：false 表示未锁定，true 表示已锁定
    private final AtomicBoolean locked = new AtomicBoolean(false);

    public void lock() throws InterruptedException {
        // 不断尝试获取锁，直到成功为止
        boolean ifLock = !locked.compareAndSet(false, true);
        while (ifLock) {
            // 自旋等待，这里可适当添加Thread.yield()或者短暂的sleep以降低CPU消耗
            Thread.sleep(1000);
        }
    }

    public void unlock() {
        // 解锁只需将状态设置回 false
        locked.set(false);
    }

    public static void main(String[] args) throws InterruptedException {
        SpinLock spinLock = new SpinLock();
        spinLock.lock();
    }
}
