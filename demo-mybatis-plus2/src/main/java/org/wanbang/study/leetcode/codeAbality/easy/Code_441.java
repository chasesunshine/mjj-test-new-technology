package org.wanbang.study.leetcode.codeAbality.easy;

/**
 * 441. 排列硬币
 * 你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
 * 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。
 *
 * 示例 1：
 * 输入：n = 5
 * 输出：2
 * 解释：因为第三行不完整，所以返回 2 。
 *
 * 示例 2：
 * 输入：n = 8
 * 输出：3
 * 解释：因为第四行不完整，所以返回 3 。
 *
 */
public class Code_441 {
    public static void main(String[] args) {
        int i = arrangeCoins(10);
        System.out.println(i);
    }

    /**
     *
     * 个人做法
     * 超出时间限制
     * 但是其实做出来了，没有优化而已
     *
     * @param n
     * @return
     */
    public static int arrangeCoins(int n) {
        if(n == 1)return 1;
        // 总和
        int sum = 1;
        // 等差比
        int interval = 2;
        while (sum <= n){
            sum = sum + interval;
            interval++;
        }
        return interval - 2;
    }


    /**
     * 数学求解法 O(1) 不含求根预算
     *
     * @param n
     * @return
     */
    public static int arrangeCoins1(int n) {
        return (int) (-1 + Math.sqrt(1 + 8 * (long) n)) / 2;
    }

    /**
     * 迭代求解法 O(n)
     *
     * @param n
     * @return
     */
    public static int arrangeCoins2(int n) {
        int i = 1;
        while (n >= i) {
            n -= i;
            i++;
        }
        return i - 1;
    }

    /**
     * 二分查找，O(log(n / 2 + 1))
     *
     * @param n
     * @return
     */
    public static int arrangeCoins3(int n) {
        long start = 0, end = (long) n / 2 + 1, mid;
        while (end - start > 1) {
            mid = (start + end) >>> 1;
            if (mid * (mid + 1) == (long) 2 * n) {
                return (int) mid;
            } else if (mid * (mid + 1) <= (long) 2 * n) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return (end * (end + 1) == (long) 2 * n) ? (int) end : (int) start;
    }
}
