package org.wanbang.study.threadPool.threadPool3.execute;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by IntelliJ IDEA.
 *
 * @author leizhimin 2008-11-25 14:28:59
 */
public class TestCachedThreadPool {
    public static void main(String[] args) {
//                ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
//         ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 5; i++) {
            executorService.execute(new TestRunnable());
            System.out.println("************* a" + i + " *************");
        }
        executorService.shutdown();
    }
}

