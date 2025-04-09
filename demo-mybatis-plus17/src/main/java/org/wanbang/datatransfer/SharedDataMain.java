package org.wanbang.datatransfer;

class SharedData {
    private volatile int data; // 使用 volatile 确保可见性

    public synchronized void setData(int data) {
        this.data = data;
    }

    public synchronized int getData() {
        return data;
    }
}

public class SharedDataMain {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sharedData.setData(i);
                System.out.println("Producer set data: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                int data = sharedData.getData();
                System.out.println("Consumer get data: " + data);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
