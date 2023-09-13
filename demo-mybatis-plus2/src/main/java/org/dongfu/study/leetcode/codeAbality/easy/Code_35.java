package org.dongfu.study.leetcode.codeAbality.easy;
/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 *
 * 示例 2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 *  
 * 提示:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 为 无重复元素 的 升序 排列数组
 * -104 <= target <= 104
 *
 */

public class Code_35 {
    /**
     *
     * 思路：
     * 这题被归纳于二分查找范围里，就是明着告诉你用二分法做啊
     *
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        int target = 7;
        int i = searchInsert(nums, target);
        System.out.println(i);
    }

    public static int searchInsert(int[] nums, int target) {
        int index = 0 ;
        if(nums.length == 0 || target < nums[0]) return 0;
        for (int i = 0; i < nums.length; i++) {
            index = i;
            if(target == nums[i]){
                return i;
            }else if(i!= 0 && target > nums[i-1] && target< nums[i]){
                return index;
            }else {
                index++;
            }

        }
        return index;
    }

    public static int searchInsert1(int[] nums, int target) {
        for(int i = 0; i < nums.length;i++){
            if(nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }

}
