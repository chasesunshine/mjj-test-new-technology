package org.wanbang.study.leetcode.codeAbality.easy;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，
 * 满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 *
 * 示例 2：
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 *
 * 示例 3：
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 */

public class Code_219 {
    /**
     * 思路：
     * 可能有多个重复的，我们只需要利用 hashmap
     * 当前的 index 减去 之前的index ，如果 小于 k 那就返回true
     * 如果 不符合，那就覆盖之前存储的 index
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1,0,1,1};
        int k = 1;
        boolean b = containsNearbyDuplicate(nums, k);

        System.out.println(b);
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            boolean b = map.containsKey(num);
            if(b){
                Integer index = map.get(num);
                if(i - index <= k){
                    return true;
                }else {
                    map.put(num,i);
                }
            }else {
                map.put(num,i);
            }

        }

        return false;
    }
}
