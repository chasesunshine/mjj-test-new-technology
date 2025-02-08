package org.wanbang.study.leetcode.codeAbality.hotquestions;

import com.alibaba.schedulerx.shade.scala.Int;

import java.util.*;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 *
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 */
public class Code_1 {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] ints = twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] twoSum(int[] nums, int target) {
        List<Integer> objects = new ArrayList<>();
        Map<Integer,Integer> integerHashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int i1 = target - num;
            Integer integer = integerHashMap.get(i1);
            if(integer != null){
                objects.add(integer);
                objects.add(i);
                int[] intArray = objects.stream().mapToInt(Integer::intValue).toArray();
                return intArray;
            }
            integerHashMap.put(num,i);
        }
        return null;
    }
}
