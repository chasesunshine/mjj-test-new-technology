package org.wanbang.study.linkedAndLinkedList.LinkedList;

/**
 * 注意，个人分析下来这是1.6的双向循环列表的源码写法
 */
public class MyLinkedList{

    private class Node{

        private Node previous = this;
        private Node next = this;
        private Object value;
        Node (Object value){
            this.value = value;
        }

        public String toString(){
            return value.toString();
        }
    }

    private Node head = new Node(null);

    private int size;

    public int getSize(){

        return size;
    }


    private boolean addFirst(Object value){//在前面添加
        addAfter(new Node(value),head);
        return true;
    }
    private boolean addlast(Object value){//在后面添加
        addBefore(new Node(value),head);
        return true;
    }


    private boolean add(Object value){//默认在后面添加
        addlast(value);
        return true;
    }
    private boolean add(int index,Object value){//在指定节点添加，即在指定节点之前添加
        addBefore(new Node(value),getNode(index));
        return true;
    }
    private Object getValue(int index){//获得指定位置节点的值
        return getNode(index).value;
    }


    private boolean remove(int index){//移除指定节点
        removeNode(getNode(index));
        return true;
    }
    private boolean removeFirst(){//删除前面的节点，从第一个节点开始删除
        removeNode(head.next);
        return true;
    }
    private boolean removeLast(){//删除后面的节点，从最后一个节点开始删除
        removeNode(head.previous);
        return true;
    }


    private Node getNode(int index){//获得指定位置的节点
        if(index<0||index>size)//注意这里判断条件
            throw new IndexOutOfBoundsException("The Index Outof Bounds");
        if(index<size/2){
            Node node = head;
            for(int i = 0;i<=index;i++){
                node = node.next;
            }
            return node;
        }
        else{
            Node node = head;
            for(int i=size-1;i>=index;--i){
                node = node.previous;
            }
            return node;
        }
    }
    private void addBefore(Node newNode,Node node){//在某个节点前面添加
        newNode.next = node;
        newNode.previous = node.previous;
        newNode.previous.next = newNode;
        newNode.next.previous = newNode;
        size++;
    }
    private void addAfter(Node newNode,Node node){//在某个节点后面添加
        newNode.next = node.next;
        newNode.previous = node;
        newNode.previous.next = newNode;
        newNode.next.previous = newNode;
        ++size;
    }
    private void removeNode(Node node){//删除某个节点
        if(size==0)
            throw new IndexOutOfBoundsException("LinkedList is Empty");
        node.previous.next = node.next;
        node.next.previous = node.previous;
        node.next = null;
        node.previous = null;
        --size;
    }
    private boolean isEmpty(){
        return size ==0;
    }

    public String toString(){
        StringBuilder str = new StringBuilder(">");
        Node node = head;
        for(int i = 0;i<size;i++){
            node = node.next;
            str.append(node.value);
            str.append(";");
        }
        return str.toString();
    }

    public static void main(String[] args) {
        MyLinkedList link = new MyLinkedList();

        link.add(4);
        link.add(7);
        link.add(8);
        System.out.println(link);

        link.addFirst(3);
        link.addFirst(2);
        link.addFirst(1);
        System.out.println(link);
        link.addlast(9);
        link.addlast(10);
        System.out.println(link);

        link.add(4, "5");
        link.add(5, 6);
        link.add(0, "在0索引出加上:0");
        System.out.println(link);
        link.add(5, "第5个索引添加后获得这个位置的值");
        System.out.println(link);
        System.out.println(link.getValue(5));
        System.out.println(link.getValue(10));
        System.out.println(link.getValue(11));
//		System.out.println(link.getValue(15));

        link.removeFirst();
        System.out.println(link);

        link.remove(4);
        System.out.println(link);

        System.out.println(link.getSize());


        link.removeLast();
        link.removeLast();
        link.removeLast();
        link.removeLast();
        link.removeLast();
        System.out.println(link);
        link.removeLast();
        link.removeLast();
        link.removeLast();
        link.removeLast();
        link.removeLast();
        System.out.println(link);
        link.removeLast();


    }
}
