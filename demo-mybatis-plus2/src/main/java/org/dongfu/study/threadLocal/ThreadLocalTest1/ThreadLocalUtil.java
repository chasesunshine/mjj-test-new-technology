package org.dongfu.study.threadLocal.ThreadLocalTest1;

// https://blog.csdn.net/never_tears/article/details/78657718
public class ThreadLocalUtil {
    // ①通过匿名内部类覆盖ThreadLocal的initialValue()方法，指定初始值
    private static ThreadLocal<Object> seqNum = new ThreadLocal<Object>() {
        public Integer initialValue() {
            return 0;
        }
    };

    // ②获取下一个序列值
    public int getNextNum() {
        seqNum.set((Integer) seqNum.get() + 1);
        return (Integer) seqNum.get();
    }
}

