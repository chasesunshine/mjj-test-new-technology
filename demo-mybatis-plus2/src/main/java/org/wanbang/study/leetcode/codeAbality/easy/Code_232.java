package org.wanbang.study.leetcode.codeAbality.easy;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

/**
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * 实现 MyQueue 类：
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 说明：
 *
 * 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 *
 * 示例 1：
 * 输入：
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 1, 1, false]
 *
 * 解释：
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 *
 */

public class Code_232 {
    public static void main(String[] args) {
        Code_232 myQueue = new Code_232();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        int peek = myQueue.peek();// return 1
        int pop = myQueue.pop();// return 1, queue is [2]
        boolean empty = myQueue.empty();// return false

        System.out.println(peek);
        System.out.println(pop);
        System.out.println(empty);
    }

    private Stack<Integer> stackInput;// 输入栈
    private Stack<Integer> stackOutput;// 输出栈

    public Code_232() {
        stackInput = new Stack<>();
        stackOutput = new Stack<>();
    }

    public void push(int x) {
        stackInput.push(x);
    }

    // Stack的pop方法是会移除的
    public int pop() {
        // 如果 输出栈 为空，则将 输入栈 全部弹出并压入 输出栈 中，然后 输出栈.pop()
        if(stackOutput.isEmpty()){
            while(!stackInput.isEmpty()){
                stackOutput.push(stackInput.pop());
            }
        }
        return stackOutput.pop();
    }

    // 返回栈顶的元素但不移除它
    public int peek() {
        if(stackOutput.isEmpty()){
            while(!stackInput.isEmpty()){
                stackOutput.push(stackInput.pop());
            }
        }
        return stackOutput.peek();
    }

    public boolean empty() {
        return stackInput.isEmpty() && stackOutput.isEmpty();
    }
}
