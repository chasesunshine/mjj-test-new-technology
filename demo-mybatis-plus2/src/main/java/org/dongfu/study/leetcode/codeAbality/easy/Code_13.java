package org.dongfu.study.leetcode.codeAbality.easy;

/**
 *
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。
 *
 *  
 *
 * 示例 1:
 * 输入: s = "III"
 * 输出: 3
 *
 * 示例 2:
 * 输入: s = "IV"
 * 输出: 4
 *
 * 示例 3:
 * 输入: s = "IX"
 * 输出: 9
 *
 * 示例 4:
 * 输入: s = "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例 5:
 *
 * 输入: s = "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 15
 * s 仅含字符 ('I', 'V', 'X', 'L', 'C', 'D', 'M')
 * 题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内
 * 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
 * IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
 * 关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics 。
 * 通过次数729,717提交次数1,171,778
 *
 */

public class Code_13 {

    /**
     * 思路：
     * 这题懂了就非常简单。首先建立一个HashMap来映射符号和值，然后对字符串从左到右来，
     * 如果当前字符代表的值不小于其右边，就加上该值；否则就减去该值。
     * 以此类推到最左边的数，最终得到的结果即是答案
     *
     */
    public static void main(String[] args) {
        //                  50 5 3
        String testValue = "LVIII";
        int i = romanToInt(testValue);
        System.out.println(i);
    }

    public static int romanToInt(String s) {
        int length = s.length();
        int[] nums = new int[length];
        int num = 0;
        for (int i = 0; i < length; i++) {
            switch (s.charAt(i)) {
                case 'M':
                    num = 1000;
                    break;
                case 'D':
                    num = 500;
                    break;
                case 'C':
                    num = 100;
                    break;
                case 'L':
                    num = 50;
                    break;
                case 'X':
                    num = 10;
                    break;
                case 'V':
                    num = 5;
                    break;
                case 'I':
                    num = 1;
                    break;
            }
            nums[i] = num;
        }

        // 若较小的数字在较大的数字前面就加负号
        int rtn = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] < nums[i+1]) {
                nums[i] = - nums[i];
            }
            rtn += nums[i];
        }
        return rtn;
    }
}
