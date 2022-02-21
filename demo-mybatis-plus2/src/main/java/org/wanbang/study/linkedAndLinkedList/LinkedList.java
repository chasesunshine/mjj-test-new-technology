package org.wanbang.study.linkedAndLinkedList;

/**
 * 双向链表LinkedList
 *
 * @program: design
 * @description: 链表实现类, 增删改查时间复杂度：O(n)
 * @author: cyj
 * @create: 2019-03-21 11:32
 **/
public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    //虚拟头节点
    private Node dummyHead;
    int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * 获取链表中的元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表的index添加元素e
     * 在链表中不是一个常用的操作，主要理解
     * 时间复杂度：O(n)
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed.  Illegal index.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;

        prev.next = new Node(e, prev.next);
        size++;

    }

    /**
     * 在链表末尾添加新得元素e
     * 时间复杂度：O(n)
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 在链表头添加元素
     * 时间复杂度：O(1)
     */
    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;

//        head = new Node(e, head);
//        size++;

        add(0, e);
    }

    /**
     * 获得链表的index处的元素e
     * 在链表中不是一个常用的操作，主要联系理解
     * 时间复杂度：O(n)
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获得链表的第一个元素
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获得链表的最后一个元素
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改链表的第index个位置的元素为e
     * 时间复杂度：O(n)
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Update failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 删除链表的第index个位置的元素为e
     * 时间复杂度：O(n)
     *
     * @param index
     */
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Update failed. Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    /**
     * 删除链表第一个元素
     * 时间复杂度：O(1)
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除链表最后一个元素
     * 时间复杂度：O(n)
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 查找链表中是否有元素e
     * 时间复杂度：O(n)
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
//        for (Node cur=dummyHead.next;cur!=null;cur=cur.next) {
//            res.append(cur + "->");
//        }
        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        //在索引为2的地方添加元素666
        linkedList.add(2, 666);
        System.out.println(linkedList);

        //删除索引为2的元素
        linkedList.remove(2);
        System.out.println(linkedList);

        //删除链表第一个元素
        linkedList.removeFirst();
        System.out.println(linkedList);

        //删除链表最后一个元素
        linkedList.removeLast();
        System.out.println(linkedList);
    }
}

