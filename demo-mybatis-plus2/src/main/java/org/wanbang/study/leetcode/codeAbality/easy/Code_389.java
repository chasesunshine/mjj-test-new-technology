package org.wanbang.study.leetcode.codeAbality.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 找不同
 *
 * 给定两个字符串 s 和 t ，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 *
 * 示例 1：
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 *
 * 示例 2：
 * 输入：s = "", t = "y"
 * 输出："y"
 *
 * 提示：
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字母
 *
 */
public class Code_389 {
    public static void main(String[] args) {
        String s = "";
        String t = "y";
        char theDifference = findTheDifference(s, t);
        System.out.println(theDifference);

        char theDifference1 = findTheDifference1(s, t);
        System.out.println(theDifference1);
    }

    /**
     * 个人写的测试通过
     *
     * @param s
     * @param t
     * @return
     */
    static char findTheDifference(String s, String t) {
        List<Character> tList = new ArrayList<>();
        if(s.length() > 0){
            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                tList.add(c);
            }
            for (int i = 0; i < s.length(); i++) {
                Character c = s.charAt(i);
                tList.remove(c);
            }
            return tList.get(0);
        }else {
            char c = t.charAt(0);
            return c;
        }
    }

    /**
     * java:将所给的字符串转换为字符数组，求字符数组的int和，作差，再转回char，返回（3ms，击败100%）
     *
     * @param s
     * @param t
     * @return
     */
    static char findTheDifference1(String s, String t) {
        char[] tChars = t.toCharArray();
        char[] sChars = s.toCharArray();
        int tSum = calculateAsciiSum(tChars);
        int sSum = calculateAsciiSum(sChars);
        int value = tSum - sSum;
        char value1 = (char) value;
        return value1;
    }

    /**
     * 计算字符数组的 ASCII 值总和
     *
     * @param charArray 字符数组
     * @return ASCII 值总和
     */
    public static int calculateAsciiSum(char[] charArray) {
        int sum = 0;
        for (char c : charArray) {
            sum += (int) c;
        }
        return sum;
    }

}
