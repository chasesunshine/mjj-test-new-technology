package org.wanbang.study.linkedListAllType;

/**
 * 单向链表
 * @param <T>
 */
public class Single<T> {
    //头结点
    private Node head;
    //链表元素个数
    private int size;

    //构造函数
    public Single(){
        this.head = null;
        this.size = 0;
    }

    class Node{
        T obj;
        Node next;
        public Node(T obj){
            this.obj = obj;
            this.next = null;
        }
    }


    public void addFirst(T obj){
        Node node = new Node(obj);
        node.next = this.head;
        this.head = node;
        this.size ++;
    }


    public static void main(String[] args) {
        Single<Integer> tSingle = new Single<>();
        for(int i = 0; i < 10; i++){
            tSingle.addFirst(i);
            System.out.println(tSingle);
        }

    }

}
