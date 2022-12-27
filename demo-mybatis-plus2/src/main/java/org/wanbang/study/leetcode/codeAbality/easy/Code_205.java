package org.wanbang.study.leetcode.codeAbality.easy;

import java.util.HashMap;

/**
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 *示例 1:
 * 输入：s = "egg", t = "add"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * 示例 3：
 *
 * 输入：s = "paper", t = "title"
 * 输出：true
 */

public class Code_205 {

    /**
     * 思路：建立双向映射
     * 前提：两个字符串长度需一致
     */
    public static void main(String[] args) {
        String a ="add";
        String b ="egg";

        boolean isomorphic = isIsomorphic(a, b);
        System.out.println(isomorphic);
    }

    public static boolean isIsomorphic(String s, String t) {
         /*
        HashMap建立双向映射
         */
        int len = s.length();
        HashMap<Character, Character> map1 = new HashMap<>();   // s[i]->t[i]
        HashMap<Character, Character> map2 = new HashMap<>();   // t[i]->s[i]
        for (int i = 0; i < len; i++) {
            char ch1 = s.charAt(i), ch2 = t.charAt(i);
            if (!map1.containsKey(ch1)) {
                map1.put(ch1, ch2);
            }
            if (!map2.containsKey(ch2)) {
                map2.put(ch2, ch1);
            }
            // 均存在的情况:排除掉不匹配的情况
            if (map1.get(ch1) != ch2 || map2.get(ch2) != ch1){
                return false;
            }
        }
        // 最后所有都匹配的情况
        return true;
    }
}
