package org.dongfu.study.leetcode.codeAbality.easy;
/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *  
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 *
 * 示例 2：
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 *
 * 提示：
 * 1 <= n <= 45
 */

public class Code_70 {
    /**
     *
     * 思路：
     *  第n个台阶只能从第n-1或者n-2个上来。
     *  到第n-1个台阶的走法 + 第n-2个台阶的走法 = 到第n个台阶的走法，
     *  已经知道了第1个和第2个台阶的走法，一路加上去。
     *
     */
    public static void main(String[] args) {
        int value = 5;
        int i = climbStairs(value);
        System.out.println(i);
    }

    public static int climbStairs(int n) {
        int a = 1, b = 2, temp;

        if(n == 1){return 1;}
        if(n == 2){return 2;}

        for(int i = 3; i <= n; i++){
            temp = a;
            a = b;
            b = temp + b;
        }

        return b;
    }
}
