package org.wanbang.study.writeHashMap.jdk8;
/**
* @description: 手写HashMap（JDK8）第二天
* @author majiajian
* @date 2022/8/31 19:34
* @version 1.0
*/

/**
 * https://blog.csdn.net/zjltju1203/article/details/90344041
 */
public class Doc {

    //    二，实现内容一览
    //    昨天实现了HashMap的基本创建和链表结构存储数据，这是JDK1.8之前的数据结构。
    //    在JDK1.8之后，HashMap引入了红黑树的概念，当链表长度超过一定值时，默认为8，就会将链表转换为红黑树。
    //
    //    几个重要参数：
    //
    //    //链表转红黑树阙值
    //    static final int TREEIFY_THRESHOLD = 8;
    //
    //    //红黑树转链表阙值
    //    static final int UNTREEIFY_THRESHOLD = 6;
    //
    //    //链表转红黑树时，检查集合容量的阙值，最小不能低于该值
    //    static final int MIN_TREEIFY_CAPACITY = 64;
    //
    //
    //    红黑树一个重要的类： TreeNode
    //    该类是HashMap中的一个静态内部类，也是红黑树的核心实现。该类包含了红黑树的所有操作，看一下类结构。

}
