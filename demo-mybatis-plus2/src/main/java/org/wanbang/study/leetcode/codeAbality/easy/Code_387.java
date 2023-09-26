package org.wanbang.study.leetcode.codeAbality.easy;

import java.util.HashMap;

/**
 * @description:  字符串中的第一个唯一字符
 *
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 *
 * 示例 1：
 * 输入: s = "leetcode"
 * 输出: 0
 *
 * 示例 2:
 * 输入: s = "loveleetcode"
 * 输出: 2
 *
 * 示例 3:
 * 输入: s = "aabb"
 * 输出: -1
 *
 */
public class Code_387 {
    public static void main(String[] args) {
        String s = "loveleetcode";
        int i = firstUniqChar(s);
        System.out.println(i);
    }

    /**
     * 个人还是看题解才做出来的
     * 思路：
     * 统计 字符和字数
     * 然后再遍历字符串 - 第一个count 为 1 的字符就是答案
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer orDefault = map.getOrDefault(c, 0);
            map.put(c,orDefault + 1);
        }
        for (int i = 0; i < s.length(); i++){
            Integer integer = map.get(s.charAt(i));
            if(integer == 1){
                return i;
            }
        }
        return -1;
    }

}
