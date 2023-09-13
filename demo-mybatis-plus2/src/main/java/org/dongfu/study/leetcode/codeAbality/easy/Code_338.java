package org.dongfu.study.leetcode.codeAbality.easy;

/**
 * @description:  比特位计数
 *
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，
 * 返回一个长度为 n + 1 的数组 ans 作为答案。
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：[0,1,1]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 *
 * 示例 2：
 * 输入：n = 5
 * 输出：[0,1,1,2,1,2]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 *
 */

/**
 * 没做出来
 */
public class Code_338 {
    public static void main(String[] args) {

    }

    /**
     * 方法一：Brian Kernighan\text{Brian Kernighan}Brian Kernighan 算法
     * 最直观的做法是对从 000 到 nnn 的每个整数直接计算「一比特数」。每个 int\texttt{int}int 型的数都可以用 323232 位二进制数表示，只要遍历其二进制表示的每一位即可得到 111 的数目。
     *
     * 利用 Brian Kernighan\text{Brian Kernighan}Brian Kernighan 算法，可以在一定程度上进一步提升计算速度。Brian Kernighan\text{Brian Kernighan}Brian Kernighan 算法的原理是：对于任意整数 xxx，令 x=x & (x−1)x=x~\&~(x-1)x=x & (x−1)，该运算将 xxx 的二进制表示的最后一个 111 变成 000。因此，对 xxx 重复该操作，直到 xxx 变成 000，则操作次数即为 xxx 的「一比特数」。
     *
     * 对于给定的 nnn，计算从 000 到 nnn 的每个整数的「一比特数」的时间都不会超过 O(log⁡n)O(\log n)O(logn)，因此总时间复杂度为 O(nlog⁡n)O(n \log n)O(nlogn)。
     *
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            bits[i] = countOnes(i);
        }
        return bits;
    }

    public int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            x &= (x - 1);
            ones++;
        }
        return ones;
    }
}
