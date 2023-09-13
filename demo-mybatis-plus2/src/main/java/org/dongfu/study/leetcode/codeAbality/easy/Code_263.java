package org.dongfu.study.leetcode.codeAbality.easy;

import java.util.Arrays;
import java.util.List;

/**
 * 丑数 就是只包含质因数 2、3 和 5 的正整数。
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 * 输入：n = 6
 * 输出：true
 * 解释：6 = 2 × 3
 *
 * 示例 2：
 * 输入：n = 1
 * 输出：true
 * 解释：1 没有质因数，因此它的全部质因数是 {2, 3, 5} 的空集。习惯上将其视作第一个丑数。
 *
 * 示例 3：
 * 输入：n = 14
 * 输出：false
 * 解释：14 不是丑数，因为它包含了另外一个质因数 7 。
 */

public class Code_263 {
    /**
     * 思路：
     * 把 2、3、5 这个list中的都整除一遍 ， 剩下的就是无法整除的数据
     * 然后判断剩下的值在不在 2、3、5这个list里面
     */
    public static void main(String[] args) {
        int value = 14;
        boolean ugly = isUgly(value);
        System.out.println(ugly);
    }

    public static boolean isUgly(int n) {
        List<Integer> integers = Arrays.asList(2, 3, 5);
        if(n == 0){
            return false;
        }
        if(n == 1){
            return true;
        }
        for (int i = 0; i < integers.size(); i++) {
            while (n % integers.get(i) == 0){
                n = n / integers.get(i);
            }
        }
        if(integers.contains(n) || n == 1){
            return true;
        }
        return false;
    }
}
