package org.wanbang.study.leetcode.codeAbality.hotquestions;

import com.alibaba.schedulerx.shade.scala.Int;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 3. 无重复字符的最长子串
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长
 * 子串
 *  的长度。
 *
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串
 *
 */
public class Code_3 {
    public static void main(String[] args) {
        String s = "jbpnbwwd";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    public static int lengthOfLongestSubstrin(String s) {
        if(s.length() <= 1){
            return s.length();
        }
        char[] chars = s.toCharArray();
        List<Character> characters = new ArrayList<>();
        int leftPoint = 0;
        int rightPoint = 0;
        int maxSize=0;

        while (leftPoint < chars.length){
            char aChar = chars[rightPoint];
            if(!characters.contains(aChar)){
                characters.add(aChar);
            }else {
                maxSize = Math.max(maxSize,characters.size());
                characters.clear();
            }
            rightPoint++;
            if(rightPoint >= chars.length){
                leftPoint++;
                rightPoint = leftPoint;
            }
        }
        return maxSize;
    }

    /**
     * 没有做出来
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        //维护当前最长不重复字符子串
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int max = 0;
        while(right < s.length()){
            if(!set.contains(s.charAt(right))){
                //未查到重复字符就一直加，right右移
                set.add(s.charAt(right));
                right++;
            }else{
                //right查到重复字符先不动，left右移，set删left经过的字符，直到重复的这个字符删掉为止
                set.remove(s.charAt(left));
                left++;
            }
            //每一次计算当前set子串的长度
            max = Math.max(max, set.size());
        }
        return max;
    }
}
