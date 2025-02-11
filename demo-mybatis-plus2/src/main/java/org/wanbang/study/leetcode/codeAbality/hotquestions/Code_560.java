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

    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }

        // key-前缀和, value-前缀和为key的个数
        // 问题转化为和为 k 的问题
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i <= n; i++) {
            // 如果有与当前 sums[i] 差为 k 的则加上它的个数
            count += map.getOrDefault(sums[i] - k, 0);
            // 前缀和的个数
            map.put(sums[i], map.getOrDefault(sums[i], 0) + 1);
        }
        return count;
    }

}
