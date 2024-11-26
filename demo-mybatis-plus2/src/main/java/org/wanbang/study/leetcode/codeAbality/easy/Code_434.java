package org.wanbang.study.leetcode.codeAbality.easy;

/**
 * 434. 字符串中的单词数
 *
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * 示例:
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 *
 */
public class Code_434 {

    public static void main(String[] args) {
        String s = "";
        int i = countSegments(s);
        System.out.println(i);
    }

    // 个人没有做出来
    // 空格分割一下，然后统计非空字符串个数
    public static int countSegments(String s) {
        int count = 0;
        for(String word: s.split(" "))
            if(!"".equals(word)) count ++;
        return count;
    }
}
