package org.wanbang.study.leetcode.codeAbality.easy;
/**
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 *  
 * 示例 1：
 * 输入:a = "11", b = "1"
 * 输出："100"
 *
 * 示例 2：
 * 输入：a = "1010", b = "1011"
 * 输出："10101"
 *  
 * 提示：
 * 1 <= a.length, b.length <= 104
 * a 和 b 仅由字符 '0' 或 '1' 组成
 * 字符串如果不是 "0" ，就不含前导零
 *
 */

public class Code_67 {
    /**
     * 思路：
     * 模拟一下进位就好， 代码很容易理解
     */
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        String s = addBinary(a, b);
        System.out.println(s);
    }

    public static String addBinary(String a, String b) {
        if(a == null || a.length() == 0) return b;
        if(b == null || b.length() == 0) return a;

        StringBuilder stb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;

        int c = 0;  // 进位
        while(i >= 0 || j >= 0) {
            if(i >= 0) c += a.charAt(i --) - '0';
            if(j >= 0) c += b.charAt(j --) - '0';
            stb.append(c % 2);
            c >>= 1;
        }

        String res = stb.reverse().toString();
        return c > 0 ? '1' + res : res;
    }
}
