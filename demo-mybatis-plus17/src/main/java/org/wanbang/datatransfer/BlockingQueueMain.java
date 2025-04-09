package org.wanbang.datatransfer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueMain {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    queue.put(i); // 阻塞式添加数据
                    System.out.println("Producer put: " + i);
                    String name = Thread.currentThread().getName();
                    System.out.println(name);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    int data = queue.take(); // 阻塞式获取数据
                    System.out.println("Consumer take: " + data);
                    String name = Thread.currentThread().getName();
                    System.out.println(name);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
