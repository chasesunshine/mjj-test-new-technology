package org.wanbang.study.linkedListAllType;

import com.alibaba.fastjson.JSON;

public class TwoWay {
    private Node head;  // 链表的头节点
    private Node tail;  // 链表的尾节点
    private int size;   // 链表的大小

    public TwoWay() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    class Node {
        int data;  // 节点的数据
        Node next; // 指向下一个节点的引用
        Node prev; // 指向前一个节点的引用

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // 在链表末尾添加一个新节点
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {  // 如果链表为空
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;  // 新节点的前驱为当前尾节点
            tail.next = newNode;  // 当前尾节点的后继为新节点
            tail = newNode;       // 更新尾节点
        }
        size++;
    }

    public static void main(String[] args) {
        TwoWay list = new TwoWay();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(JSON.toJSONString(list));
    }
}
