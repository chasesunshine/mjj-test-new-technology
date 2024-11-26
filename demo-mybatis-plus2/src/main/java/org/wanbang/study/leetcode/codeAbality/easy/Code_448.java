package org.wanbang.study.leetcode.codeAbality.easy;

import com.alibaba.schedulerx.shade.scala.Int;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 448. 找到所有数组中消失的数字
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 *
 * 示例 1：
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 *
 * 示例 2：
 * 输入：nums = [1,1]
 * 输出：[2]
 *
 */
public class Code_448 {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> disappearedNumbers = findDisappearedNumbers(nums);
        System.out.println(disappearedNumbers);
    }

    /**
     * 个人做法
     * 超出时间限制
     *
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> objects = new ArrayList<>();
        List<Integer> list = IntStream.of(nums).boxed().collect(Collectors.toList());
        for (int i = 0; i < nums.length; i++) {
            if(!list.contains(i+1)){
                objects.add(i+1);
            }
        }
        return objects;
    }

    /**
     * 其他人做法
     *  数组就是下标
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> res = new ArrayList<>();
        boolean[] tmp = new boolean[nums.length + 1];
        for (int num : nums) {
            tmp[num] = true;
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!tmp[i]) {
                res.add(i);
            }
        }
        return res;
    }

}
