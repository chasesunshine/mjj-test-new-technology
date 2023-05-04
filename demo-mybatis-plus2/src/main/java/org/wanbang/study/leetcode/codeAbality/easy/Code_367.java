package org.wanbang.study.leetcode.codeAbality.easy;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:  有效的完全平方数
 *
 * 给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * 完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。
 * 不能使用任何内置的库函数，如  sqrt 。
 *
 * 示例 1：
 * 输入：num = 16
 * 输出：true
 * 解释：返回 true ，因为 4 * 4 = 16 且 4 是一个整数。
 *
 * 示例 2：
 * 输入：num = 14
 * 输出：false
 * 解释：返回 false ，因为 3.742 * 3.742 = 14 但 3.742 不是一个整数。
 */
public class Code_367 {
    public static void main(String[] args) {
        int num = 14;
        boolean perfectSquare = isPerfectSquare(num);
        boolean perfectSquare1 = isPerfectSquare1(num);

        System.out.println(perfectSquare);
        System.out.println(perfectSquare1);
    }

    /**
     * 个人做出来了，但是思想其实一般
     * @param num
     * @return
     */
    public static boolean isPerfectSquare(int num) {
        if(num == 1) return true;
        for (int j = 0; j <= num / 2 ; j++) {
            if(num ==  j*j){
                return true;
            }else if(j*j > num){
                break;
            }
        }
        return false;
    }

    /**
     *
     * 方法二：暴力
     * 思路和算法
     * 如果 num\textit{num}num 为完全平方数，那么一定存在正整数 xxx 满足
     * x×x=numx \times x = \textit{num}x×x=num。于是我们可以从 111 开始，
     * 从小到大遍历所有正整数，寻找是否存在满足 x×x=numx \times x = \textit{num}x×x=num 的正整数 xxx。
     * 在遍历中，如果出现正整数 xxx 使 x×x>numx \times x > \textit{num}x×x>num，
     * 那么更大的正整数也不可能满足 x×x=numx \times x = \textit{num}x×x=num，
     * 不需要继续遍历了。
     *
     */
    public static boolean isPerfectSquare1(int num) {
        long x = 1, square = 1;
        while (square <= num) {
            if (square == num) {
                return true;
            }
            ++x;
            square = x * x;
        }
        return false;
    }

}
