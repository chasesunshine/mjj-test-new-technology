package org.wanbang.study.leetcode.codeAbality.easy;

/**
 * 461. 汉明距离
 *
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 *
 * 示例 1：
 * 输入：x = 1, y = 4
 * 输出：2
 * 解释：
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 *
 * 示例 2：
 * 输入：x = 3, y = 1
 * 输出：1
 *
 */
public class Code_461 {
    public static void main(String[] args) {
        int x = 3, y = 1;
        int i = hammingDistance(x, y);
        System.out.println(i);
    }

    /**
     * 个人没有做出来
     *
     * 思想，翻转
     * 与或异或方式处理
     *
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance(int x, int y) {
        int d = 0;
        int z = x ^ y;
        while (z != 0) {
            z = z & (z - 1);
            d++;
        }
        return d;
    }
}
