package org.wanbang.datatransfer;

import java.util.concurrent.Exchanger;

public class ExchangerMain {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        Thread threadA = new Thread(() -> {
            try {
                String data = "Hello from A";
                System.out.println("Thread A sending: " + data);
                String received = exchanger.exchange(data); // 交换数据
                System.out.println("Thread A received: " + received);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                String data = "Hello from B";
                System.out.println("Thread B sending: " + data);
                String received = exchanger.exchange(data); // 交换数据
                System.out.println("Thread B received: " + received);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
    }
}
