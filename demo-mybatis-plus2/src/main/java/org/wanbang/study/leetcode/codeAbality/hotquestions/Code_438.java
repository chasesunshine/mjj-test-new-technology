package org.wanbang.study.leetcode.codeAbality.hotquestions;

import com.alibaba.fastjson.JSON;
import com.alibaba.schedulerx.shade.scala.Int;
import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 438. 找到字符串中所有字母异位词
 * 中等
 * 相关标签
 * 相关企业
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的
 * 异位词
 *  的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 *
 * 示例 1:
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *
 *  示例 2:
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *
 */
public class Code_438 {

    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        List<Integer> anagrams = findAnagrams(s, p);
        System.out.println(JSON.toJSONString(anagrams));
    }

    /**
     * 个人做法：超出时间限制，个人打算换一种方式
     *
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams1(String s, String p) {
        List<Integer> resultList = new ArrayList<>();
        int leftIndex = 0;
        char[] chars1 = p.toCharArray();
        List<Character> strings = new String(chars1).chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        while (leftIndex < s.length()-p.length()+1){
            String substring = s.substring(leftIndex,leftIndex+p.length());
            char[] chars = substring.toCharArray();
            List<Character> charList = new String(chars).chars().mapToObj(c -> (char) c).collect(Collectors.toList());

            ArrayList<Character> characters = new ArrayList<>(strings);
            for (int i = 0; i < charList.size(); i++) {
                Character character = charList.get(i);
                if(!characters.contains(character)){
                    break;
                }else {
                    characters.remove(character);
                }
            }
            if(characters.size() == 0){
                resultList.add(leftIndex);
            }

            leftIndex++;
        }

        return resultList;
    }

    /**
     * 第二种方式:超出时间限制
     *
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams2(String s, String p) {
        List<Integer> resultList = new ArrayList<>();
        int leftIndex = 0;
        List<Character> hashCodeList = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            // 将字符转换为其ASCII值并累加到sum中
            sum += (int) ch;
            hashCodeList.add(ch);
        }

        while (leftIndex < s.length()-p.length()+1){
            String substring = s.substring(leftIndex,leftIndex+p.length());

            int sum1 = 0;
            boolean flag = true;
            for (int i = 0; i < substring.length(); i++) {
                char ch = substring.charAt(i);
                // 将字符转换为其ASCII值并累加到sum中
                sum1 += (int) ch;
                if(!hashCodeList.contains(ch)){
                    flag = false;
                    break;
                }
            }

            if(sum==sum1 && flag){
                resultList.add(leftIndex);
            }

            leftIndex++;
        }

        return resultList;
    }

    /**
     * 第三种方式：直接排序, 成功了
     *
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams3(String s, String p) {
        List<Integer> resultList = new ArrayList<>();
        int leftIndex = 0;
        char[] pArray = p.toCharArray();
        Arrays.sort(pArray);

        while (leftIndex < s.length()-p.length()+1){
            String substring = s.substring(leftIndex,leftIndex+p.length());
            char[] chars = substring.toCharArray();
            Arrays.sort(chars);

            if(Arrays.equals(pArray,chars)){
                resultList.add(leftIndex);
            }
            leftIndex++;
        }

        return resultList;
    }

    /**
     * 第三种方式：直接排序, 超出时间限制，这个对我来讲是想到的最简单的做法了
     *
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams4(String s, String p) {
        List<Integer> resultList = new ArrayList<>();
        int leftIndex = 0;
        char[] pArray = p.toCharArray();
        Arrays.sort(pArray);

        String pString = Arrays.toString(pArray);

        while (leftIndex < s.length()-p.length()+1){
            String substring = s.substring(leftIndex,leftIndex+p.length());
            char[] chars = substring.toCharArray();
            Arrays.sort(chars);

            String toString = Arrays.toString(chars);
            if(pString.equals(toString)){
                resultList.add(leftIndex);
            }
            leftIndex++;
        }

        return resultList;
    }


    public static List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        List<Integer> res = new ArrayList<>();
        int i = 0,  j = p.length();

        char[] pChars = p.toCharArray();
        Arrays.sort(pChars);

        while (j <= n) {
            String substr = s.substring(i, j);
            char[] substrChars = substr.toCharArray();
            Arrays.sort(substrChars);

            if (Arrays.equals(substrChars, pChars)) {
                res.add(i);
            }
            j++;
            i++;
        }

        return res;
    }

}
