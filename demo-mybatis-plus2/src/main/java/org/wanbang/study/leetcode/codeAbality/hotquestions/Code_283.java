package org.wanbang.study.leetcode.codeAbality.hotquestions;

import java.util.Arrays;

/**
 * 283. 移动零
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 示例 2:
 * 输入: nums = [0]
 * 输出: [0]
 *
 */
public class Code_283 {
    public static void main(String[] args) {
        int[] nums = {0,0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 个人用时 10分钟（算是符合要求）
     * 个人思路：这里得用双指针，这个双指针是指两层遍历，外层i，内层j
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(num != 0 ){
                continue;
            }
            for (int j = i+1; j < nums.length; j++) {
                int num1 = nums[j];
                if(num1 != 0 ){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    break;
                }
            }
        }
    }
}
