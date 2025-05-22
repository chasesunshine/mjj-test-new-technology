package org.wanbang.study.sortedlinkedlist;

import java.util.Comparator;

public class SortedLinkedList<E> {
    private Node<E> head;
    private final Comparator<? super E> comparator;
    private int size;

    // 内部节点类
    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    // 默认使用自然排序
    public SortedLinkedList() {
        this(null);
    }

    // 使用自定义比较器
    public SortedLinkedList(Comparator<? super E> comparator) {
        this.comparator = comparator;
        this.head = null;
        this.size = 0;
    }

    // 添加元素
    public void add(E element) {
        if (element == null) {
            throw new NullPointerException("Cannot add null element");
        }

        Node<E> newNode = new Node<>(element);

        // 如果链表为空或新元素小于头节点
        if (head == null || compare(element, head.data) < 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<E> current = head;

            // 找到合适的插入位置
            while (current.next != null && compare(element, current.next.data) >= 0) {
                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    // 比较两个元素
    @SuppressWarnings("unchecked")
    private int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        } else {
            return ((Comparable<? super E>) e1).compareTo(e2);
        }
    }

    // 获取链表大小
    public int size() {
        return size;
    }

    // 检查链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 转换为字符串表示
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

}
