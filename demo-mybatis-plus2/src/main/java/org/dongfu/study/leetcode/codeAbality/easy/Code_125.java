package org.dongfu.study.leetcode.codeAbality.easy;
/**
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * 字母和数字都属于字母数字字符。
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出：true
 * 解释："amanaplanacanalpanama" 是回文串。
 *
 * 示例 2：
 * 输入：s = "race a car"
 * 输出：false
 * 解释："raceacar" 不是回文串。
 *
 * 示例 3：
 * 输入：s = " "
 * 输出：true
 * 解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
 * 由于空字符串正着反着读都一样，所以是回文串。
 *
 * 提示：
 *
 * 1 <= s.length <= 2 * 105
 * s 仅由可打印的 ASCII 字符组成
 */

public class Code_125 {
    /**
     * 思路：解题思路： (自己做出来了)
     *
     * 第一步：使用正则替换掉所有非字母、数字还有空格，用toLowerCase()将字符串转换成小写
     * 第二步：将字符串转化成数组，用reverse()颠倒元素顺序，再用join()将其转换成字符串于原字符串进行对比
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean palindrome = isPalindrome(s);

        System.out.println(palindrome);
    }


    public static boolean isPalindrome(String s) {
        // 使用正则替换掉所有非字母、数字还有空格
        s = s.replaceAll("[^a-zA-Z0-9\\s]","");
        s = s.replace(" ", "");
        // 用toLowerCase()将字符串转换成小写
        s = s.toLowerCase();
        // 用reverse()颠倒元素顺序
        String s1 = new StringBuffer(s).reverse().toString();

        return s.equals(s1);
    }

}
