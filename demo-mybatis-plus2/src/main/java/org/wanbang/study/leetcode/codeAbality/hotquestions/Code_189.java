package org.wanbang.study.leetcode.codeAbality.hotquestions;

import com.alibaba.schedulerx.shade.scala.Int;

import java.util.*;

/**
 * 189. 轮转数组
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 *
 * 示例 2:
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 *
 */
public class Code_189 {
    public static void main(String[] args) {
        int[] nums = {-1,-100,3,99};
        int k = 2;
        rotate(nums,k);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 个人思路 : 思路错误
     * @param nums
     * @param k
     */
    public static void rotate1(int[] nums, int k) {
        if(k>=nums.length){
            return;
        }
        // 1. 首先把最后k位置的给截出来
        // 2. 然后使用队列存储从头到 nums.length - k 的数据
        // 3. 最后把k里面的数据放到最前面 ，队列中取出来放在原数组中
        Queue<Integer> queue = new LinkedList<>();
        int[] ints = Arrays.copyOfRange(nums, nums.length - k, nums.length);
        for (int i = 0; i < nums.length-k; i++) {
            queue.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if(i < ints.length){
                nums[i] = ints[i];
            }else {
                nums[i] = queue.poll();
            }
        }
    }

    /**
     * 个人自己做出来了，但是讲道理可以优化
     * 1. 将位置信息和数值放入到hashmap
     * 2. 从第一位开始计算往后挪几位
     *
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k){
        // 将位置信息和数值放入到hashmap
        // 从第一位开始计算往后挪几位
        Map<Integer, Integer> mapping = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int index = i + k;
            while (index >= nums.length) {
                index = index - nums.length;
            }
            mapping.put(index,nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = mapping.get(i);
        }
    }
}
