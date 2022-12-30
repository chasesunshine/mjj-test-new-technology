package org.wanbang.study.leetcode.codeAbality.easy;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
*/

public class Code_242 {

    /**
     * 思路：利用栈的思想
     * value.remove(Character.valueOf(c));
     */
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean anagram = isAnagram(s, t);

        System.out.println(anagram);

        // 栈，先进后出
//        Stack<Integer> value = new Stack();
//        value.push(2);
//        value.push(5);
//        value.push(1);
//        value.push(3);
//        value.push(1);
//        value.push(4);
//        System.out.println(JSON.toJSONString(value));
//
//        int search = value.search(1);
//        System.out.println(search);
//        value.remove(search);
//        System.out.println(JSON.toJSONString(value));
//
//        Integer pop = value.pop();
//        System.out.println(pop);
//        System.out.println(JSON.toJSONString(value));
    }

    public static boolean isAnagram(String s, String t) {
        Stack<Character> value = new Stack();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            value.push(c);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int search = value.search(c);
            if(search < 1){
                return false;
            }
            value.remove(Character.valueOf(c));
        }

        return value.empty();
    }
}
