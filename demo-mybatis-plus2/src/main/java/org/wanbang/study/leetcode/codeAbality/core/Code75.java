package org.wanbang.study.leetcode.codeAbality.core;

import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 交替合并字符串
 *
 * 给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。
 * 如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
 * 返回 合并后的字符串 。
 *
 *
 * 示例 1：
 * 输入：word1 = "abc", word2 = "pqr"
 * 输出："apbqcr"
 * 解释：字符串合并情况如下所示：
 * word1：  a   b   c
 * word2：    p   q   r
 * 合并后：  a p b q c r
 *
 * 示例 2：
 * 输入：word1 = "ab", word2 = "pqrs"
 * 输出："apbqrs"
 * 解释：注意，word2 比 word1 长，"rs" 需要追加到合并后字符串的末尾。
 * word1：  a   b
 * word2：    p   q   r   s
 * 合并后：  a p b q   r   s
 *
 * 示例 3：
 * 输入：word1 = "abcd", word2 = "pq"
 * 输出："apbqcd"
 * 解释：注意，word1 比 word2 长，"cd" 需要追加到合并后字符串的末尾。
 * word1：  a   b   c   d
 * word2：    p   q
 * 合并后：  a p b q c   d
 *
 */
public class Code75 {

    public static void main(String[] args) {
        String word1 = "ab";
        String word2 = "pqrs";
        String s = mergeAlternately(word1, word2);
        System.out.println(s);
    }

    public static String mergeAlternately(String word1, String word2) {
        Queue<Character> charsQueue1 = new ArrayDeque<>();
        Queue<Character> charsQueue2 = new ArrayDeque<>();
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            charsQueue1.add(chars1[i]);
        }
        for (int i = 0; i < chars2.length; i++) {
            charsQueue2.add(chars2[i]);
        }

        StringBuilder stringBuilder = new StringBuilder("");
        while (!(charsQueue1.size() == 0 && charsQueue2.size() == 0)){
            if(charsQueue1.size() != 0){
                Character poll = charsQueue1.poll();
                stringBuilder.append(poll.toString());
            }
            if(charsQueue2.size() != 0){
                Character poll = charsQueue2.poll();
                stringBuilder.append(poll.toString());
            }
        }

        return stringBuilder.toString();
    }

    /**
     * 双指针思路还算不错
     *
     * @param word1
     * @param word2
     * @return
     */
    public String mergeAlternately2(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int i = 0, j = 0;

        StringBuilder ans = new StringBuilder();
        while (i < m || j < n) {
            if (i < m) {
                ans.append(word1.charAt(i));
                ++i;
            }
            if (j < n) {
                ans.append(word2.charAt(j));
                ++j;
            }
        }
        return ans.toString();
    }


}
