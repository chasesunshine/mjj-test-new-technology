package org.wanbang.study.leetcode.codeAbality.easy;
/**
 * @description: https://leetcode.cn/problems/palindrome-number/
 * @author majiajian
 * @date 2022/10/20 14:19
 * @version 1.0
 */

import com.alibaba.schedulerx.shade.scala.Int;

/**
 *
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 例如，121 是回文，而 123 不是。
 *  
 * 示例 1：
 * 输入：x = 121
 * 输出：true
 *
 * 示例 2：
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3：
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 *  
 *
 * 提示：
 * -231 <= x <= 231 - 1
 *
 */
public class Code_9 {
    public static void main(String[] args) {
        Integer value = 1;
        boolean palindrome = isPalindrome(value);

        System.out.println(palindrome);
    }

    public static boolean isPalindrome(int x) {
        return true;
    }
}
