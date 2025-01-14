package org.wanbang.study.leetcode.codeAbality.easy;

import org.assertj.core.util.Arrays;

import java.util.List;

/**
 * 485. 最大连续 1 的个数
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 *
 * 示例 1：
 * 输入：nums = [1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 *
 * 示例 2:
 * 输入：nums = [1,0,1,1,0,1]
 * 输出：2
 *
 */
public class Code_485 {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        int maxConsecutiveOnes = findMaxConsecutiveOnes(nums);
        System.out.println(maxConsecutiveOnes);
    }

    /**
     * 个人思想： 双指针
     * 做出来了
     *
     * @param nums
     * @return
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int currentNum = 0;
        int maxNum = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(num != 0){
                currentNum++;
            }else {
                if(currentNum > maxNum){
                    maxNum = currentNum;
                }
                currentNum = 0;
            }
        }

        return currentNum > maxNum ? currentNum:maxNum;
    }

}

