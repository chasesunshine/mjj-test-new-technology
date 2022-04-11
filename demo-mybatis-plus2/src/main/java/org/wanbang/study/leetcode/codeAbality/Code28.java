package org.wanbang.study.leetcode.codeAbality;

// https://leetcode-cn.com/problems/implement-strstr/

import lombok.extern.slf4j.Slf4j;

/**
 * 28. 实现 strStr()
 * 实现 strStr() 函数。
 *
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 *
 *
 *
 * 说明：
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 *
 *
 *
 * 示例 1：
 *
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * 示例 2：
 *
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * 示例 3：
 *
 * 输入：haystack = "", needle = ""
 * 输出：0
 */
@Slf4j
public class Code28 {
    public static void main(String[] args) {
        int i = strStr("", "");
        System.out.println(i);
    }

    public static int strStr(String haystack, String needle) {
        log.info("https://blog.csdn.net/qq_43842093/article/details/122277175");
        log.info("可以配合indexOf(String s)的使用，如果包含，返回的值是包含该子字符串在父类字符串中起始位置；如果不包含必定全部返回值为-1");
        log.info("String类型有一个方法：contains（）,该方法是判断字符串中是否有子字符串。如果有则返回true，如果没有则返回false。");
        boolean contains = haystack.contains(needle);
        int value = -1;
        if(contains){
            value = haystack.indexOf(needle);
        }
        return value;
    }
}
