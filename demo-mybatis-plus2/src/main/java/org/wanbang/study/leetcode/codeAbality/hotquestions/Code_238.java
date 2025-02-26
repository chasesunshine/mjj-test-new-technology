package org.wanbang.study.leetcode.codeAbality.hotquestions;

import java.util.Arrays;

/**
 * 238. 除自身以外数组的乘积
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 示例 1:
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 *
 * 示例 2:
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 *
 */
public class Code_238 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] ints = productExceptSelf(nums);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 个人思路：用递归 ，但是没啥用
     *
     * @param nums
     * @return
     */
    /**
     * 前缀积&后缀积
     * 讲道理 看不懂
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int pre = 1;
        int suf = 1;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = pre;
            pre *= nums[i];
        }
        for (int j = n - 1; j >= 0; j--) {
            ans[j] *= suf;
            suf *= nums[j];
        }
        return ans;
    }

}
