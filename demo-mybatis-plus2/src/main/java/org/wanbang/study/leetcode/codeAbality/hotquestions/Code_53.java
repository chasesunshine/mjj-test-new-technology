package org.wanbang.study.leetcode.codeAbality.hotquestions;

import java.util.Arrays;

/**
 * 53. 最大子数组和
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组
 * 是数组中的一个连续部分。
 *
 *
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * 示例 2：
 * 输入：nums = [1]
 * 输出：1
 *
 * 示例 3：
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *
 */
public class Code_53 {
    public static void main(String[] args) {
        int[] nums = {-1,-3,-2};
        int i = maxSubArray(nums);
        System.out.println(i);
    }

    /**
     * 超出时间限制 204 / 210 个通过的测试用例
     *
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
        int index = 0;
        int max = nums[0];
        int sum = nums[0];
        while (index < nums.length){
            sum = nums[index];
            int innerIndex = index+1;
            while (innerIndex < nums.length){
                sum = sum + nums[innerIndex];
                if(sum > max){
                    max = sum;
                }
                innerIndex ++;
            }
            index ++;
        }
        int result = max > sum ? max : sum;
        Arrays.sort(nums);
        return result > nums[nums.length-1] ? result : nums[nums.length-1] ;
    }

    /**
     * 力扣上面的
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
            if(sum > max){
                max = sum;
            }
            if(sum <= 0){
                sum = 0;
            }

        }
        return max;
    }

}
