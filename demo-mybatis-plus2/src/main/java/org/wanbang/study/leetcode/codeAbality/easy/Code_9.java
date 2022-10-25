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

    /**
     *
     * 思路：
     * 0 是回文数
     * 负数和除 0 以外以 0 结尾的数都不是回文数
     * 记录 x 后一半的翻转，如 x = 4334，reversed = 43；x = 54345，reversed = 54
     * x有偶数位和奇数位两种情况
     *
     */
    public static void main(String[] args) {
        Integer value = 53488435;
        boolean palindrome = isPalindrome(value);
        boolean palindrome1 = isPalindrome1(value);

        System.out.println(palindrome);
        System.out.println(palindrome1);
    }

    // 这个还是好理解的
    public static boolean isPalindrome(int x) {
        // 0 是回文数
        if (x == 0) return true;
        // 负数和除 0 以外以 0 结尾的数都不是回文数
        if (x < 0 || x % 10 == 0) return false;
        // 记录 x 后一半的翻转，如 x = 4334，reversed = 43；x = 54345，reversed = 54
        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        // x有偶数位和奇数位两种情况
        return reversed == x || reversed / 10 == x;
    }

    public static boolean isPalindrome1(int x) {
        if(x<0)return false;
        int a=x;
        int sum=0;
        while(x!=0){
            sum=sum*10+x%10;
            x/=10;
        }
        return sum==a;
    }
}
