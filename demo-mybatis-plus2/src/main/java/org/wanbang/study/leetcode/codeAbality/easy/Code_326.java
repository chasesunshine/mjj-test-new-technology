package org.wanbang.study.leetcode.codeAbality.easy;

/**
 * @description: 3 的幂
 *
 *给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 *
 * 示例 1：
 * 输入：n = 27
 * 输出：true
 *
 * 示例 2：
 * 输入：n = 0
 * 输出：false
 *
 * 示例 3：
 * 输入：n = 9
 * 输出：true
 *
 * 示例 4：
 * 输入：n = 45
 * 输出：false
 */

public class Code_326 {
    public static void main(String[] args) {
        boolean powerOfThree = isPowerOfThree(19682);
        System.out.println(powerOfThree);
    }

    /**
     * 思路与算法
     * 我们不断地将 nnn 除以 333，直到 n=1n=1n=1。如果此过程中 nnn 无法被 333 整除，就说明 nnn 不是 333 的幂。
     * 本题中的 nnn 可以为负数或 000，可以直接提前判断该情况并返回 False\text{False}False，也可以进行试除，因为负数或 000 也无法通过多次除以 333 得到 111。
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfThree(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }


    /**
     * 个人思路错误
     */
//    public static boolean isPowerOfThree(int n) {
//        if(n < 3 && n != 1){
//            return false;
//        }
//        return isPowerOfThree1(n);
//    }
//
//    private static boolean isPowerOfThree1(int n) {
//        if(n == 1){
//            return true;
//        }else if( n < 3){
//            return false;
//        }
//        int ceil = (int)Math.ceil(((double) n) / 3);
//        return isPowerOfThree1(ceil);
//    }
}
