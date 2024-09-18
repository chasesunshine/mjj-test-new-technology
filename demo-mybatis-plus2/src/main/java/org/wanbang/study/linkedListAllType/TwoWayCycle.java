package org.wanbang.study.linkedListAllType;

import com.alibaba.fastjson.JSON;

public class TwoWayCycle {
    private Node head;  // 头节点
    private Node tail;  // 尾节点
    private int size;   // 链表大小

    public TwoWayCycle() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    class Node {
        int data;
        Node next;  // 指向下一个节点
        Node prev;  // 指向前一个节点

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // 在链表末尾添加元素
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {  // 如果链表为空
            head = newNode;
            tail = newNode;
            newNode.next = newNode;  // 形成环
            newNode.prev = newNode;
        } else {
            tail.next = newNode;  // 新节点成为新的尾部
            newNode.prev = tail;
            tail = newNode;
            tail.next = head;  // 更新尾部并保持环状
            head.prev = tail;
        }
        size++;
    }

    public static void main(String[] args) {
        TwoWayCycle list = new TwoWayCycle();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(JSON.toJSONString(list));
    }
}
