package org.wanbang.study.leetcode.codeAbality.easy;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 猜数字大小
 *
 * 猜数字游戏的规则如下：
 *
 * 每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
 * 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
 * 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：
 *
 * -1：我选出的数字比你猜的数字小 pick < num
 * 1：我选出的数字比你猜的数字大 pick > num
 * 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
 * 返回我选出的数字。
 *
 * 示例 1：
 * 输入：n = 10, pick = 6
 * 输出：6
 *
 * 示例 2：
 * 输入：n = 1, pick = 1
 * 输出：1
 *
 * 示例 3：
 * 输入：n = 2, pick = 1
 * 输出：1
 *
 * 示例 4：
 * 输入：n = 2, pick = 2
 * 输出：2
 *
 */
public class Code_374 {
    public static void main(String[] args) {

    }

    /**
     * 这道题个人没做出来
     *
     * 方法一：二分查找
     * 记选出的数字为 pick\textit{pick}pick，猜测的数字为 xxx。根据题目描述，
     * 若 guess(x)≤0\texttt{guess}(x)\le 0guess(x)≤0 则说明 x≥pickx\ge\textit{pick}x≥pick，
     * 否则 x<pickx<\textit{pick}x<pick。
     * 根据这一性质我们可以使用二分查找来求出答案 pick\textit{pick}pick。
     * 二分时，记当前区间为 [left,right][\textit{left},\textit{right}][left,right]，
     * 初始时 left=1\textit{left}=1left=1，right=n\textit{right}=nright=n。
     * 记区间中间元素为 mid\textit{mid}mid，若有 guess(mid)≤0\texttt{guess}(mid)\le 0guess(mid)≤0
     * 则说明 pick∈[left,mid]\textit{pick} \in [\textit{left},\textit{mid}]pick∈[left,mid]，
     * 否则 pick∈[mid+1,right]\textit{pick} \in [\textit{mid}+1,\textit{right}]pick∈[mid+1,right]。
     * 当区间左右端点相同时，则说明我们找到了答案，退出循环。
     *
     */
    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left < right) { // 循环直至区间左右端点相同
            int mid = left + (right - left) / 2; // 防止计算时溢出
            if (guess(mid) <= 0) {
                right = mid; // 答案在区间 [left, mid] 中
            } else {
                left = mid + 1; // 答案在区间 [mid+1, right] 中
            }
        }
        // 此时有 left == right，区间缩为一个点，即为答案
        return left;
    }

    private static int guess(int mid) {
        return 0;
    }

}