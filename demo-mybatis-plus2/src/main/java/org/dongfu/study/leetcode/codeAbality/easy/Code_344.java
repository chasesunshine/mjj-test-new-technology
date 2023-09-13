package org.dongfu.study.leetcode.codeAbality.easy;

import com.alibaba.fastjson.JSON;

import java.util.Stack;

/**
 * @description:  反转字符串
 *
 *编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 示例 1：
 * 输入：s = ["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 *
 * 示例 2：
 * 输入：s = ["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 *
 */
public class Code_344 {
    public static void main(String[] args) {
        char[] chars = new char[]{'h','e','l','l','o'};
        reverseString(chars);

    }

    /**
     * 个人用 栈
     * @param s
     */
    public static void reverseString(char[] s) {
        Stack stack = new Stack();
        for (int i = 0; i < s.length; i++) {
            stack.push(s[i]);
        }
        for (int i = 0; i < s.length; i++) {
            char ch = stack.pop().toString().charAt(0);
            s[i] = ch;
        }
        System.out.println(JSON.toJSONString(s));
    }
}
