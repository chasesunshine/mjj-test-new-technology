package org.wanbang.study.leetcode.codeAbality.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 判断子序列
 *
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 进阶：
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 * 示例 1：
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 *
 */
public class Code_392 {
    public static void main(String[] args) {
        String s = "ab";
        String t = "baab";
        boolean subsequence = isSubsequence(s, t);
        System.out.println(subsequence);
    }

    public static boolean isSubsequence(String s, String t) {
        if(t.length() < s.length()){
            return false;
        }

        int slow = 0;
        int fast = 0;

        while(slow < s.length() && fast < t.length()){
            if(s.charAt(slow) == t.charAt(fast)){
                slow++;
                fast++;
            }else{
                fast++;
            }
        }

        return slow == s.length();
    }

    // 双指针思想
    public static boolean isSubsequence1(String s, String t){
        if(s.length() > t.length()){
            return false;
        }
        int slow = 0;
        int fast = 0;

        while (slow < s.length() && fast < t.length()){
            if(s.charAt(slow) == t.charAt(fast)){
                slow ++;
                fast ++;
            }else {
                fast++;
            }
        }
        return slow == s.length();
    }

}
