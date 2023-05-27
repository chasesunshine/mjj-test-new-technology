package org.wanbang.study.lruDemo;

/**
 * 如何手写一个LRU算法
 *  https://blog.csdn.net/czxlylc/article/details/102763156?spm=1001.2101.3001.6650.18&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-18-102763156-blog-124662300.235%5Ev36%5Epc_relevant_default_base3&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-18-102763156-blog-124662300.235%5Ev36%5Epc_relevant_default_base3&utm_relevant_index=24
 *
 *
 *
 */
public class Doc {

    /**
     * LRU算法概念
     * LRU 是Least Recently Used的缩写，简称最近最少使用。
     *
     * 也就是说在Redis中内存满了，会优先淘汰那些最近最不常访问的数据。那在Java中用什么数据结构去实现呢？
     * 一种的话是基于LinkedHashMap，一种是自己设计数据结构，使用链表+HashMap。
     *
     *
     * LinkedHashMap数据结构
     * LinkedHashMap继承了HashMap，拥有HashMap的所有特性，同时LinkedHashMap在增加了head和tail指针，用于实现双向链表
     * LinkedHashMap默认按照插入顺序保存数据，新的数据插入双向链表尾部
     * LinkedHashMap中有构造方法支持按顺序访问，最新访问的数据放到链表尾部
     *
     *
     *
     * 总结
     * 本篇文章基于Redis的缓存淘汰策略介绍了LRU算法的背景，基本概念。基于LinkedHashMap的特性实现了简易版的LRU算法，
     * 并介绍LinkedHashMap内部的基本原理来帮助大家更好的理解LRU算法的实现。
     */
}
