package org.wanbang.study.leetcode.codeAbality;

// https://leetcode-cn.com/problems/number-of-1-bits/

import lombok.extern.slf4j.Slf4j;

/**
 * 191. 位1的个数
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 *
 *
 *
 * 提示：
 *
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。
 *
 *
 * 示例 1：
 *
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * 示例 2：
 *
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 * 示例 3：
 *
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 */
@Slf4j
public class Code191 {
    public static void main(String[] args) {
        int i = hammingWeight(00000000000000000000000000001011);
        int i1 = hammingWeight1(00000000000000000000000000001011);
        System.out.println(i);
        System.out.println(i1);


        log.info("String.valueOf(00000000000000000000000000001011); 最后转换为 521 是八进制");
        String s = String.valueOf(00000000000000000000000000001011);
        System.out.println(s);
        String str = Integer.toBinaryString(00000000000000000000000000001011);
        System.out.println(str);
    }

    public static int hammingWeight(int n) {
        int value = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                value++;
            }
        }
        return value;
    }

    // 第二种解法
    public static int hammingWeight1(int n) {
        String str = Integer.toBinaryString(n);
        int count=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1')
                count++;
        }
        return count;
    }
}
