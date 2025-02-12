package org.wanbang.study.leetcode.codeAbality.hotquestions;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为 K 的子数组
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 *
 * 示例 2：
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 *
 */
public class Code_560 {
    public static void main(String[] args) {
        int [] nums = {1,2,1,2,1};
        int k = 3;
        int i = subarraySum(nums, k);
        System.out.println(i);
    }

    /**
     * 这个思路简单
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if (a == k) {
                ++sum;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (a + nums[j] == k) {
                    ++sum;
                }
                a = a + nums[j];
            }
        }
        return sum;
    }

}
