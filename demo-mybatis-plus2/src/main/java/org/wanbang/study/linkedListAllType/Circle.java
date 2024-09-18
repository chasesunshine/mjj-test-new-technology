package org.wanbang.study.linkedListAllType;

import com.alibaba.fastjson.JSON;

/**
 * 循环链表
 * @param <T>
 */
public class Circle<T> {
    private Node head;  // 头节点
    private Node tail;  // 尾节点

    public Circle() {
        this.head = null;
        this.tail = null;
    }

    class Node{
        T obj;
        Node next;
        public Node(T obj){
            this.obj = obj;
            this.next = null;
        }
    }

    // 在尾部添加元素
    public void add(T obj){
        Node newNode = new Node(obj);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;  // 形成环
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;  // 更新尾部并保持环状
        }
    }


    public static void main(String[] args) {
        Circle<Integer> list = new Circle<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(JSON.toJSONString(list));
    }
}
