package org.dongfu.study.leetcode.codeAbality;

// https://leetcode-cn.com/problems/repeated-substring-pattern/

import lombok.extern.slf4j.Slf4j;

/**
 *
 * 459. 重复的子字符串
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "abab"
 * 输出: true
 * 解释: 可由子串 "ab" 重复两次构成。
 * 示例 2:
 *
 * 输入: s = "aba"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "abcabcabcabc"
 * 输出: true
 * 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
 *
 */
@Slf4j
public class Code459 {
    public static void main(String[] args) {
        boolean b = repeatedSubstringPattern("abaababaab");
        System.out.println(b);
    }

    // https://leetcode-cn.com/problems/repeated-substring-pattern/solution/zhong-fu-de-zi-zi-fu-chuan-by-leetcode-solution/
    // 解题思路
    public static boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i * 2 <= n; ++i) {
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; ++j) {
                    // charAt() 方法用于返回指定索引处的字符。索引范围为从 0 到 length() - 1。
                    char c = s.charAt(j);
                    char c1 = s.charAt(j - i);
                    if (c != c1) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }

}
