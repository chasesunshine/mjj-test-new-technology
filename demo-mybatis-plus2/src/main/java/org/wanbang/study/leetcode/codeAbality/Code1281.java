package org.wanbang.study.leetcode.codeAbality;

// https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/

/**
 *
 * 1281. 整数的各位积和之差
 * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 234
 * 输出：15
 * 解释：
 * 各位数之积 = 2 * 3 * 4 = 24
 * 各位数之和 = 2 + 3 + 4 = 9
 * 结果 = 24 - 9 = 15
 * 示例 2：
 *
 * 输入：n = 4421
 * 输出：21
 * 解释：
 * 各位数之积 = 4 * 4 * 2 * 1 = 32
 * 各位数之和 = 4 + 4 + 2 + 1 = 11
 * 结果 = 32 - 11 = 21
 *
 */
public class Code1281 {
    public static void main(String[] args) {
        int i = subtractProductAndSum(4421);
        System.out.println(i);
    }

    public static int subtractProductAndSum(int n) {
        String value = String.valueOf(n);
        Integer a = 1;
        Integer b = 0;
        for (int i = 0; i < value.length(); i++) {
                a = a * Integer.parseInt(value.substring(i,i+1));
                b = b + Integer.parseInt(value.substring(i,i+1));
        }

        return a-b;
    }
}
