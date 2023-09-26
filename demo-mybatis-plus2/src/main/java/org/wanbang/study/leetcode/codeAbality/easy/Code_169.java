package org.wanbang.study.leetcode.codeAbality.easy;

import java.util.HashMap;

/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1：
 * 输入：nums = [3,2,3]
 * 输出：3
 *
 * 示例 2：
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 */

public class Code_169 {

    /**
     *
     * 思路：利用hashmap
     *
     */
    public static void main(String[] args) {
        int[] ints = {2,2,1,1,1,2,2};
        int i = majorityElement(ints);
        System.out.println(i);
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int half = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) == null){
                map.put(nums[i],1);
            }else {
                Integer integer = map.get(nums[i]);
                map.put(nums[i],integer+1);
                if(integer+1 > half){
                    return nums[i];
                }
            }
        }
        return 1;
    }

}
