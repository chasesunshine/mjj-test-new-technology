package org.dongfu.study.javaCache;

/**
 * https://blog.csdn.net/Pluto372/article/details/120722977
 */
public class Doc{
    /**
     * 缓存
     * 什么是缓存？
     * 平常的开发项目中，多多少少都会使用到缓存，因为一些数据我们没有必要每次查询的时候都去查询到数据库。
     *
     * 缓存的使用场景：
     * 在Java应用中，对于访问频率高，更新少的数据，通常的方案是将这类数据加入缓存中，相对从数据库中读取，读缓存效率会有很大提升。
     * 在集群环境下，常用的分布式缓存有Redis等。但在某些业务场景上，可能不需要去搭建一套复杂的分布式缓存系统，在单机环境下，通常是会希望使用内部的缓存(LocalCache)。
     *
     * 使用map缓存
     * 方案：
     *
     * 基于ConcurrentHashMap实现数据缓存，实现线程安全要求
     * SoftReference：当内存不够的时候，GC会回收SoftReference所引用的对象
     * SoftReference是软引用，它保存的对象实例，除非JVM即OutOfMemory，否则不会被GC回收。这个特性使得它特别适合设计对象Cache。对于Cache，
     * 我们希望被缓存的对象最好始终常驻内存，但是如果JVM内存吃紧，为了不发生OutOfMemoryError导致系统崩溃，必要的时候也允许JVM回收Cache的内存，
     * 待后续合适的时机再把数据重新Load到Cache中。这样可以系统设计得更具弹性。
     */

}

