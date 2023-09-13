package org.dongfu.study.leetcode.codeAbality.easy;
/**
 *给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 *
 * 示例 1：
 * 输入：n = 1
 * 输出：true
 * 解释：20 = 1
 *
 * 示例 2：
 * 输入：n = 16
 * 输出：true
 * 解释：24 = 16
 *
 * 示例 3：
 * 输入：n = 3
 * 输出：false
 *
 * 示例 4：
 * 输入：n = 4
 * 输出：true
 *
 * 示例 5：
 * 输入：n = 5
 * 输出：false
 */

public class Code_231 {
    /**
     * 思路：
     * 个人用递归做出来了，但是此题不让用递归
     *
     *
     * 一个数 nnn 是 222 的幂，当且仅当 nnn 是正整数，并且 nnn 的二进制表示中仅包含 111 个 111。
     * 因此我们可以考虑使用位运算，将 nnn 的二进制表示中最低位的那个 111 提取出来，再判断剩余的数值是否为 000 即可。下面介绍两种常见的与「二进制表示中最低位」相关的位运算技巧。
     *
     */
    public static void main(String[] args) {
        boolean powerOfTwo = isPowerOfTwo(1024);
        System.out.println(powerOfTwo);
    }

    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }


//    public static boolean isPowerOfTwo(int n) {
//        boolean result = isPowerOfTwo1(n,1);
//        return result;
//    }
//
//    private static boolean isPowerOfTwo1(int n, int i) {
//        i = i *2;
//        if(n == 1 || n == 2 || n == i){
//            return true;
//        }
//        if(n < i){
//            return false;
//        }
//        return isPowerOfTwo1(n,i);
//    }
}
