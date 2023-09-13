package org.dongfu.study.writeHashMap.jdk7.util;
/**
* @description: TODO
* @author majiajian
* @date 2022/8/31 17:15
* @version 1.0
*/

import java.util.ArrayList;
import java.util.Set;

/**
 * @desc: HashMap的简单实现
 * @author: YanMingXin
 * @create: 2021/8/9-9:46
 **/
public class MyHashMap<K, V> {

    /**
     * 默认容量16
     */
    private final int DEFAULT_CAPACITY = 16;

    /**
     * 内部存储结构
     */
    private Node[] table = new Node[DEFAULT_CAPACITY];

    /**
     * 长度
     */
    private int size = 0;

    /**
     * keySet
     */
    private Set<K> keySet;

    /**
     * 获取大小
     *
     * @return
     */
    public int size() {
        return this.size;
    }

    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * get方法
     *
     * @param key
     * @return
     */
    public Object get(Object key) {
        int hashValue = hash(key);
        int i = indexFor(hashValue, table.length);
        for (Node node = table[i]; node != null; node = node.next) {
            if (node.key.equals(key) && hashValue == node.hash) {
                return node.value;
            }
        }
        return null;
    }

    /**
     * put方法
     *
     * @param key
     * @param value
     * @return
     */
    public Object put(Object key, Object value) {
        //通过key,求hash值
        int hashValue = hash(key);
        //通过hash,找到这个key应该放的位置
        int i = indexFor(hashValue, table.length);
        //i位置已经有数据了，往链表添加元素
        Node node1 = table[i];
        for (Node node = node1 ; node != null; node = node.next) {
            Object k;
            //且数组中有这个key,覆盖其value
            if (node.hash == hashValue && ((k = node.key) == key || key.equals(k))) {
                Object oldValue = node.value;
                node.value = value;
                //返回oldValue
                return oldValue;
            }
        }
        //如果i位置没有数据，或i位置有数据，但key是新的key,新增节点
        addEntry(key, value, hashValue, i);
        return null;
    }

    /**
     * 增加节点
     *
     * @param key
     * @param value
     * @param hashValue
     * @param i
     */
    public void addEntry(Object key, Object value, int hashValue, int i) {
        //如果超过了原数组大小，则扩大数组
        if (++size == table.length) {
            Node[] newTable = new Node[table.length * 2];
            System.arraycopy(table, 0, newTable, 0, table.length);
            table = newTable;
        }
        //的到i位置的数据
        Node eNode = table[i];
        //新增节点，将该节点的next指向前一个节点
        table[i] = new Node(hashValue, key, value, eNode);
    }

    /**
     * 获取插入的位置
     *
     * @param hashValue
     * @param length
     * @return
     */
    public int indexFor(int hashValue, int length) {
        return hashValue % length;
    }

    /**
     * 获取hash值
     *
     * @param key
     * @return
     */
    public int hash(Object key) {
        return key.hashCode();
    }


    /**
     * toString方法
     *
     * @return
     */
    @Override
    public String toString() {
        ArrayList list = new ArrayList<Node>();
        for (Node node : table) {
            if (node != null) {
                list.add(node);
            }
        }
        return list.toString();
    }

}
