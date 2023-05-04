package org.wanbang.study.leetcode.codeAbality.easy;

/**
 * @description:  4的幂
 *
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 *
 * 示例 1：
 * 输入：n = 16
 * 输出：true
 *
 * 示例 2：
 * 输入：n = 5
 * 输出：false
 *
 * 示例 3：
 * 输入：n = 1
 * 输出：true
 *
 */
public class Code_342 {
    public static void main(String[] args) {
        boolean powerOfFour = isPowerOfFour(16);
        System.out.println(powerOfFour);
    }
    public static boolean isPowerOfFour(int n) {
        while (n != 0 && n % 4 == 0){
            n = n /4;
        }
        return n == 1;
    }
}
