package org.wanbang.study.leetcode.codeAbality.easy;

import com.alibaba.schedulerx.shade.scala.collection.mutable.HashSet;

/**
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 * 示例 1：
 * 输入：nums = [1,2,3,1]
 * 输出：true
 *
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：false
 *
 * 示例 3：
 * 输入：nums = [1,1,1,3,3,4,3,2,4,2]
 * 输出：true
 */

public class Code_217 {
    /**
     * 思路：
     * 利用hashset不可重复性
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        boolean b = containsDuplicate(nums);
        System.out.println(b);
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> integerHashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            boolean b = integerHashSet.contains(num);
            if(b){
                return true;
            }
            integerHashSet.add(num);
        }
        return false;
    }
}
