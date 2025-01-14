package org.wanbang.study.leetcode.codeAbality.easy;

/**
 * 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
 * 示例 1:
 * 输入: num = 100
 * 输出: "202"
 *
 * 示例 2:
 * 输入: num = -7
 * 输出: "-10"
 *
 */
public class Code_504 {

    public static void main(String[] args) {
        String convert = convertToBase7(100);
        System.out.println(convert);
    }

    /**
     * Integer.toString(int i, int radix) 是 Java 中的一个静态方法，
     * 它将一个整数 i 转换为指定进制（基数）的字符串表示。这个方法对于需要以不同进制格式（如二进制、八进制或十六进制）显示数字的情况非常有用。
     *
     * @param num
     * @return
     */
    public static String convertToBase7(int num) {
        return Integer.toString(num, 7);
    }

}
