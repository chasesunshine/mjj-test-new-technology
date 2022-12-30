package org.wanbang.study.leetcode.codeAbality.easy;
/**
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
 *
 * 示例 1:
 * 输入: num = 38
 * 输出: 2
 * 解释: 各位相加的过程为：
 * 38 --> 3 + 8 --> 11
 * 11 --> 1 + 1 --> 2
 * 由于 2 是一位数，所以返回 2。
 *
 * 示例 2:
 * 输入: num = 0
 * 输出: 0
 */

public class Code_258 {
    /**
     * 思路：
     * 递归 - 个人做出来了
     */
    public static void main(String[] args) {
        int value = 123456;
        int i = addDigits(value);

        System.out.println(i);
    }

    public static int addDigits(int num) {
        int sum = 0;
        while (num / 10 > 0 ){
            sum = sum + num % 10;
            num = num /10;
        }
        sum = sum + num;
        if(sum < 10){
            return sum;
        }
        return addDigits(sum);
    }
}
