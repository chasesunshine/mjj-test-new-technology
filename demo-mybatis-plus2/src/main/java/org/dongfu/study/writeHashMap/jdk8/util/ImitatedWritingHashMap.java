package org.dongfu.study.writeHashMap.jdk8.util;
/**
* @description: TODO
* @author majiajian
* @date 2022/8/31 19:36
* @version 1.0
*/

import java.io.Serializable;
import java.util.*;
import java.util.logging.Logger;

public class ImitatedWritingHashMap<K, V> extends AbstractMap implements Map, Cloneable, Serializable {

    static Logger logger = Logger.getLogger(ImitatedWritingHashMap.class.getName());

    //初始化容器容量，默认大小16
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    //最大容量,Integer.MAX_VALUE的一半，超过这个容量，
    static final int MAXIMUM_CAPACITY = 1 << 30;

    //默认容载因子，表示容器的使用情况，也是容器扩容的重要指标之一
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    //扩容指标，容器根据该值判断是否需要扩容
    transient int threshold;

    transient final float loadFactor;

    //链表转红黑树阙值
    static final int TREEIFY_THRESHOLD = 8;

    //链表转红黑树时，检查集合容量的阙值，最小不能低于该值
    static final int MIN_TREEIFY_CAPACITY = 64;

    //map桶数组
    transient Node<K, V>[] table;

    transient Set<Map.Entry<K, V>> entrySet;

    //map长度
    transient int size;

    transient int modCount;
    private K key;
    private V value;

    public ImitatedWritingHashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;

        logger.info("默认初始化构造器");
    }

    public ImitatedWritingHashMap(int initialCapacity, float loadFactor) {
        logger.info("（容器容量：+" + initialCapacity + "，容载因子:" + loadFactor + "）构造器");
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " + initialCapacity);

        if (initialCapacity > MAXIMUM_CAPACITY)
            initialCapacity = MAXIMUM_CAPACITY;

        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " + loadFactor);

        this.loadFactor = loadFactor;

        //初步计算一个阙值
        this.threshold = tableSizeFor(initialCapacity);
    }

    public ImitatedWritingHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    //计算需要数组的长度
    final int tableSizeFor(int initialCapacity) {
        int n = initialCapacity - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    //初始化或重新规划
    Node<K, V>[] resize() {
        Node<K, V>[] oldTab = table;
        //旧容器容量
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        //旧阙值
        int oldThr = threshold;

        int newCap, newThr = 0;

        if (oldCap > 0) {
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            } else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY && oldCap >= DEFAULT_INITIAL_CAPACITY) {
                newThr = oldThr << 1;
            }
        } else if (oldThr > 0)
            newCap = oldThr;
        else {
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int) (DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }

        if (newThr == 0) {
            float ft = (float) newCap * loadFactor;

            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float) MAXIMUM_CAPACITY ? (int) ft : Integer.MAX_VALUE);
        }

        threshold = newThr;

        Node<K, V>[] newTab = (Node<K, V>[]) new Node[newCap];
        table = newTab;

        //扩容原集合
        if (oldTab != null) {
            for (int j = 0; j < oldCap; ++j) {
                Node<K,V> oldNode;

                if((oldNode=oldTab[j])!=null){
                    oldTab[j] = null;

                    if (oldNode.next == null)
                        newTab[oldNode.hash & (newCap - 1)] = oldNode;
                    else if (oldNode instanceof TreeNode){
                        ((TreeNode<K,V>)oldNode).split(this, newTab, j,  oldCap);
                    }else{
                        Node<K,V> loHead = null, loTail = null;  //
                        Node<K,V> hiHead = null, hiTail = null;
                        Node<K,V> next;
                        /**
                         * 核心难点
                         *
                         * 将链表 拆分为两个链表（这里本人也不清楚拆分成两个重新组合链表的优点，欢迎大神指点。。。）
                         */
                        do {
                            next = oldNode.next;
                            if ((oldNode.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = oldNode;
                                else
                                    loTail.next = oldNode;
                                loTail = oldNode;
                            }
                            else {
                                if (hiTail == null)
                                    hiHead = oldNode;
                                else
                                    hiTail.next = oldNode;
                                hiTail = oldNode;
                            }
                        } while ((oldNode = next) != null);

                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }

                }
            }
        }

        return newTab;
    }

    /**
     *
     * @param hash 哈希值
     * @param key  键值
     * @param value  值
     * @param onlyIfAbsent 如果为true，不覆盖已有的值
     * @param evict  备用，LinkedHashMap有用
     * @return
     */
    V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) {
        logger.info("putVal: "+hash+","+key+","+value);
        Node<K, V>[] hashTab;
        Node<K, V> tempNode;
        int n, i;

        if ((hashTab = table) == null || (n = hashTab.length) == 0)
            n = (hashTab = resize()).length;
        if ((tempNode = hashTab[i = (n - 1) & hash]) == null)
            hashTab[i] = newNode(hash, key, value, null);
        else{
            Node<K,V> insertNode; K k;
            //找到重复项
            if (tempNode.hash == hash &&
                    ((k = tempNode.key) == key || (key != null && key.equals(k))))
                insertNode = tempNode;
            else if (tempNode instanceof TreeNode)
                insertNode = ((TreeNode<K,V>)tempNode).putTreeVal(this, hashTab, hash, key, value);
            else{
                for (int binCount = 0; ; ++binCount) {
                    if ((insertNode = tempNode.next) == null) {
                        tempNode.next = newNode(hash, key, value, null);
                        //链表转红黑树
                        if (binCount >= TREEIFY_THRESHOLD - 1)
                            treeifyBin(hashTab, hash);
                        break;
                    }
                    if (insertNode.hash == hash &&
                            ((k = insertNode.key) == key || (key != null && key.equals(k))))
                        break;
                    tempNode = insertNode;
                }
            }

            if (insertNode != null) {
                V oldValue = insertNode.value;
                if (!onlyIfAbsent || oldValue == null)
                    insertNode.value = value;

                return oldValue;
            }

        }
        ++modCount;
        if (++size > threshold)
            resize();
        //afterNodeInsertion(evict);
        return null;
    }

    final void treeifyBin(Node<K,V>[] tab, int hash) {
        int n, index; Node<K,V> e;
        if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
            resize();
        else if ((e = tab[index = (n - 1) & hash]) != null) {
            TreeNode<K,V> hd = null, tl = null;
            do {
                TreeNode<K,V> p = replacementTreeNode(e, null);
                if (tl == null)
                    hd = p;
                else {
                    p.prev = tl;
                    tl.next = p;
                }
                tl = p;
            } while ((e = e.next) != null);
            if ((tab[index] = hd) != null)
                hd.treeify(tab);
        }
    }

    @Override
    public final Object put(Object k, Object v) {
        K key =(K)k;
        V value =(V)v;
        return putVal(hash(key), key, value, false, true);
    }

    @Override
    public Object get(Object key) {
        Node<K,V> e;
        return (e = getNode(hash(key), key)) == null ? null : e.value;
    }

    final Node<K,V> getNode(int hash, Object key) {
        Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
        if ((tab = table) != null && (n = tab.length) > 0 && (first = tab[(n - 1) & hash]) != null) {
            if (first.hash == hash && ((k = first.key) == key || (key != null && key.equals(k))))
                return first;

            if ((e = first.next) != null) {
                //红黑树查找
                if (first instanceof TreeNode)
                    return ((TreeNode<K,V>)first).getTreeNode(hash, key);
                do {
                    if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k))))
                        return e;
                } while ((e = e.next) != null);
            }
        }
        return null;
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    Node<K,V> newNode(int hash, K key, V value, Node<K,V> next) {
        return new Node<>(hash, key, value, next);
    }

    public static void main(String[] args) {
        ImitatedWritingHashMap map = new ImitatedWritingHashMap();

        for(int i=0;i<999999;i++){
            map.put("2w"+i,"2w");
        }

    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }

    static class Entry<K,V> extends Node<K,V> {
        Entry<K,V> before, after;
        Entry(int hash, K key, V value, Node<K,V> next) {
            super(hash, key, value, next);
        }
    }


    Node<K,V> replacementNode(Node<K,V> p, Node<K,V> next) {
        return new Node<>(p.hash, p.key, p.value, next);
    }

    // 创建一个树节点
    TreeNode<K,V> newTreeNode(int hash, K key, V value, Node<K,V> next) {
        return new TreeNode<>(hash, key, value, next);
    }

    //链表节点转换为树节点
    TreeNode<K,V> replacementTreeNode(Node<K,V> p, Node<K,V> next) {
        return new TreeNode<>(p.hash, p.key, p.value, next);
    }
}


