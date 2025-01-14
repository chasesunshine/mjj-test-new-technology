package org.wanbang.study.leetcode.codeAbality.easy;

/**
 * 405. 数字转换为十六进制数
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 * 答案字符串中的所有字母都应该是小写字符，并且除了 0 本身之外，答案中不应该有任何前置零。
 * 注意: 不允许使用任何由库提供的将数字直接转换或格式化为十六进制的方法来解决这个问题。
 *
 * 示例 1：
 * 输入：num = 26
 * 输出："1a"
 *
 * 示例 2：
 * 输入：num = -1
 * 输出："ffffffff"
 *
 */
public class Code_405 {
    public static void main(String[] args) {
        String s = toHex(11);
        System.out.println(s);
    }

    // 没有做出来
    public static String toHex(int num) {
        if (num == 0)
            return "0";
        char[] chars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        StringBuilder sb = new StringBuilder();
        while (sb.length() < 8 && num != 0) {
            sb.append(chars[num & 0xf]);
            num >>= 4;
        }
        return sb.reverse().toString();
    }
}
