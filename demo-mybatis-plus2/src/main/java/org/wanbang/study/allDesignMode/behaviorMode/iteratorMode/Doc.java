package org.wanbang.study.allDesignMode.behaviorMode.iteratorMode;
/**
* @description: 迭代器模式
* @author majiajian
* @date 2022/8/19 13:39
* @version 1.0
*/

/**
 *
 * 迭代器模式，常⻅的就是我们⽇常使⽤的 iterator 遍历。虽然这个设计模式在我们的实际业务开发中
 * 的场景并不多，但却⼏乎每天都要使⽤ jdk 为我们提供的 list 集合遍历。另外增强的for循环虽然是循
 * 环输出数据，但是他不是迭代器模式。迭代器模式的特点是实现 Iterable 接⼝，通过 next 的⽅式获
 * 取集合元素，同时具备对元素的删除等操作。⽽增强的for循环是不可以的。
 * 这种设计模式的优点是可以让我们以相同的⽅式，遍历不同的数据结构元素，这些数据结构包括； 数
 * 组 、 链表 、 树 等，⽽⽤户在使⽤遍历的时候并不需要去关⼼每⼀种数据结构的遍历处理逻辑，从让使
 * ⽤变得统⼀易⽤。
 *
 */
public class Doc {

    /**
     * 迭代器的设计模式从以上的功能实现可以看到，满⾜了单⼀职责和开闭原则，外界的调⽤⽅也不需
     * 要知道任何⼀个不同的数据结构在使⽤上的遍历差异。可以⾮常⽅便的扩展，也让整个遍历变得更
     * 加⼲净整洁。
     * 但从结构的实现上可以看到，迭代器模式的实现过程相对来说是⽐较负责的，类的实现上也扩增了
     * 需要外部定义的类，使得遍历与原数据结构分开。虽然这是⽐较麻烦的，但可以看到在使⽤java的
     * jdk时候，迭代器的模式还是很好⽤的，可以⾮常⽅便扩展和升级。
     * 以上的设计模式场景实现过程可能对新⼈有⼀些不好理解点，包括；迭代器三个和接⼝的定义、树
     * 形结构的数据关系、树结构深度遍历思路。这些都需要反复实现练习才能深⼊的理解，事必躬亲，
     * 亲历亲为，才能让⾃⼰掌握这些知识。
     */
}
