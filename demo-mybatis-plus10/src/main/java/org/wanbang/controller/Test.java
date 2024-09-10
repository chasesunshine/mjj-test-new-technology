package org.wanbang.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            hashMap.put(i,i);
        }

//        String s1 = "abc";
//        String s2 = new String("abc");
//
//        try (BufferedReader reader = Files.newBufferedReader(Paths.get("123"))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            System.err.println("Error reading file: " + e.getMessage());
//        }
//
//
//        LinkedHashMap<String, String> stringStringLinkedHashMap = new LinkedHashMap<>();
//        stringStringLinkedHashMap.put("","");
//
//        List<String> strings = new LinkedList<>();
//        strings.add("1");
//        strings.get(0);
//        List<String> strings1 = new ArrayList<>();
//        strings1.add("1");
//        strings1.get(0);
    }

    Node[] nodes;

    class Node{
        Integer prev;
        Object data;
        Node nextNode;
    }



}


class DeadLockDemo {
    private static Object resource1 = new Object();//􁩒􁃠 1
    private static Object resource2 = new Object();//􁩒􁃠 2
    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource2");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "get resource2");
                }
            }
        }, "􁕚􁑕 1").start();


        new Thread(() -> {
            synchronized (resource2) {
                System.out.println(Thread.currentThread() + "get resource2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource1");
                synchronized (resource1) {
                    System.out.println(Thread.currentThread() + "get resource1");
                }
            }
        }, "􁕚􁑕 2").start();
    }
}


class TestThread{
    private static Object resource1 = new Object();//􁩒􁃠 1
    private static Object resource2 = new Object();//􁩒􁃠 2
    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource2");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "get resource2");
                }
            }
        }, "thread 2").start();
    }

}