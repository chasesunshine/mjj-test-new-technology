package org.wanbang.study.leetcode.codeAbality.hotquestions;

import com.alibaba.schedulerx.shade.scala.Int;

import java.util.*;

/**
 * 128. 最长连续序列
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *
 */
public class Code_128 {
    public static void main(String[] args) {
        int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
        int i = longestConsecutive(nums);
        System.out.println(i);
    }

    /**
     * 个人做出来了：用时 30分钟（对于面试来讲肯定是不行的）
     * 思路：
     *
     *
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        // 无序但是元素不重复
        Set<Integer> valueSet = new HashSet<>();
        if(nums.length < 1){
            return 0;
        }
        // 进行排序
        Arrays.sort(nums);

        // 双指针思想
        // 最大长度
        int maxLength = 1;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // 当前的值 -1
            int value = num - 1;

            // 如果hashset中没有就清空hashset，清空之前要判断是否大于最大长度
            if(!valueSet.contains(value)) {
                int size = valueSet.size();
                if (size > maxLength) {
                    maxLength = size;
                }
                valueSet.clear();
            }
            valueSet.add(num);
        }
        return (valueSet.size() > maxLength)?valueSet.size() :maxLength;
    }
}
