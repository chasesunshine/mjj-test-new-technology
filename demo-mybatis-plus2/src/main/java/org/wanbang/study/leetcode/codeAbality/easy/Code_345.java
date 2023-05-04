package org.wanbang.study.leetcode.codeAbality.easy;

import com.alibaba.fastjson.JSON;

import java.util.Stack;

/**
 * @description:反转字符串中的元音字母
 *
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。
 *
 * 示例 1：
 * 输入：s = "hello"
 * 输出："holle"
 *
 * 示例 2：
 * 输入：s = "leetcode"
 * 输出："leotcede"
 *
 */
public class Code_345 {
    public static void main(String[] args) {

    }

    /**
     * 个人 不会
     *
     * 方法一：双指针
     * 思路与算法
     * 我们可以使用两个指针 iii 和 jjj 对字符串相向地进行遍历。
     * 具体地，指针 iii 初始时指向字符串 sss 的首位，指针 jjj 初始时指向字符串 sss 的末位。在遍历的过程中，
     * 我们不停地将 iii 向右移动，直到 iii 指向一个元音字母（或者超出字符串的边界范围）；
     * 同时，我们不停地将 jjj 向左移动，直到 jjj 指向一个元音字母。此时，如果 i<ji<ji<j，
     * 那么我们交换 iii 和 jjj 指向的元音字母，否则说明所有的元音字母均已遍历过，就可以退出遍历的过程。
     *
     */
    public static String reverseVowels(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int i = 0, j = n - 1;
        while (i < j) {
            while (i < n && !isVowel(arr[i])) {
                ++i;
            }
            while (j > 0 && !isVowel(arr[j])) {
                --j;
            }
            if (i < j) {
                swap(arr, i, j);
                ++i;
                --j;
            }
        }
        return new String(arr);
    }

    public static boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
