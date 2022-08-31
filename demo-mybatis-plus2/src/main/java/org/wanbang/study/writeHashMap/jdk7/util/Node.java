package org.wanbang.study.writeHashMap.jdk7.util;
/**
* @description: TODO
* @author majiajian
* @date 2022/8/31 17:17
* @version 1.0
*/

/**
 * 静态内部类
 */
public class Node<V> {
    int hash;//hash值
    Object key;//key
    Object value;//value
    Node<V> next;//指向下个节点（单例表）

    Node(int hash, Object key, Object value, Node<V> next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public Object getKey() {
        return this.key;
    }

    public Object getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "{" + key + ", " + value + "}";
    }

}
