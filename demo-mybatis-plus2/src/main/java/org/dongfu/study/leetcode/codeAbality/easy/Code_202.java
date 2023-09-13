package org.dongfu.study.leetcode.codeAbality.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」 定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 *
 * 示例 1：
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * 示例 2：
 * 输入：n = 2
 * 输出：false
 */

public class Code_202 {
    /**
     * 思路：
     *  根据我们的探索，我们猜测会有以下三种可能。
     * 最终会得到 111。
     * 最终会进入循环。
     * 值会越来越大，最后接近无穷大。
     *
     *算法
     * 算法分为两部分，我们需要设计和编写代码。
     * 给一个数字 nnn，它的下一个数字是什么？
     * 按照一系列的数字来判断我们是否进入了一个循环。
     * 第 1 部分我们按照题目的要求做数位分离，求平方和。
     * 第 2 部分可以使用哈希集合完成。每次生成链中的下一个数字时，我们都会检查它是否已经在哈希集合中。
     * 如果它不在哈希集合中，我们应该添加它。
     * 如果它在哈希集合中，这意味着我们处于一个循环中，因此应该返回 false。
     * 我们使用哈希集合而不是向量、列表或数组的原因是因为我们反复检查其中是否存在某数字。检查数字是否在哈希集合中需要 O(1)O(1)O(1) 的时间，而对于其他数据结构，则需要 O(n)O(n)O(n) 的时间。选择正确的数据结构是解决这些问题的关键部分。
     *
     */
    public static void main(String[] args) {
        int n = 19;
        boolean happy = isHappy(n);
        System.out.println(happy);
    }

    public static boolean isHappy(int n) {
        Set<Integer> circle = new HashSet<>();
        while (n != 1 && !circle.contains(n)){
            circle.add(n);
            n = getSum(n);
        }
        return n == 1;
    }

    private static int getSum(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }


}
