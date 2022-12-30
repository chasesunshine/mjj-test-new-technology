package org.wanbang.study.leetcode.codeAbality.easy;

import java.util.Arrays;

/**
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * 示例 1：
 *
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 *
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：2
 * 解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 *
 * 示例 3：
 * 输入：nums = [9,6,4,2,3,5,7,0,1]
 * 输出：8
 * 解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
 *
 * 示例 4：
 * 输入：nums = [0]
 * 输出：1
 * 解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。
 */

public class Code_268 {
    /**
     * 思路：
     * 很简单，先将数组进行排序，然后遍历，后一个减去前一个
     * 如果不等于1，说明中间隔开一个数字，直接返回
     * 注意头尾的操作
     */
    public static void main(String[] args) {
        int[] value = new int[]{0};
        int i = missingNumber(value);
        System.out.println(i);
    }

    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length -1; i++) {
            int num1 = nums[i];
            int num2 = nums[i+1];
            if(num2 - num1 != 1){
                return num2 -1;
            }
        }
        return nums[nums.length-1] == nums.length ? 0: nums[nums.length-1]+1;
    }
}
