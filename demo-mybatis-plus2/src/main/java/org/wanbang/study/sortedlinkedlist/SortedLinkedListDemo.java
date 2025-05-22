package org.wanbang.study.sortedlinkedlist;

import java.util.Comparator;

public class SortedLinkedListDemo {

    public static void main(String[] args) {
        // 创建自然排序的有序链表
        SortedLinkedList<Integer> intList = new SortedLinkedList<>();
        intList.add(5);
        intList.add(2);
        intList.add(8);
        intList.add(1);
        System.out.println("自然排序的整数链表: " + intList);

        // 创建自定义排序的有序链表（降序）
        SortedLinkedList<Integer> reverseIntList = new SortedLinkedList<>(Comparator.reverseOrder());
        reverseIntList.add(5);
        reverseIntList.add(2);
        reverseIntList.add(8);
        reverseIntList.add(1);
        System.out.println("降序排序的整数链表: " + reverseIntList);

        // 字符串链表
        SortedLinkedList<String> strList = new SortedLinkedList<>();
        strList.add("banana");
        strList.add("apple");
        strList.add("orange");
        System.out.println("自然排序的字符串链表: " + strList);
    }
}

