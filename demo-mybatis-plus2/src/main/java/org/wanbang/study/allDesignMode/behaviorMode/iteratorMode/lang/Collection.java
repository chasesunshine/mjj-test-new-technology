package org.wanbang.study.allDesignMode.behaviorMode.iteratorMode.lang;
/**
* @description: TODO
* @author majiajian
* @date 2022/8/19 13:49
* @version 1.0
*/

public interface Collection<E, L> extends Iterable<E> {
    boolean add(E e);
    boolean remove(E e);
    boolean addLink(String key, L l);
    boolean removeLink(String key);
    Iterator<E> iterator();
}
