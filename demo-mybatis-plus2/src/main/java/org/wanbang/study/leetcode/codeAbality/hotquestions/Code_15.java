package org.wanbang.study.leetcode.codeAbality.hotquestions;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 15. 三数之和
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 *示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 *
 * 示例 2：
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 *
 * 示例 3：
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 *
 */
public class Code_15 {
    public static void main(String[] args) {
        int[] nums = {1,2,-2,-1};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(JSON.toJSONString(lists));
    }

    /**
     * 个人思路： 超出时间限制
     *
     * @param nums
     * @return
     */
    /*public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int num2 = nums[j];
                int[] ints = Arrays.copyOfRange(nums, j+1, nums.length);
                int targetValue = -(num1+num2);
                List<Integer> collect = Arrays.stream(ints).boxed().collect(Collectors.toList());
                if(collect.contains(targetValue)){
                    List<Integer> integers = Arrays.asList(num1, num2, targetValue);
                    List<Integer> collect1 = integers.stream().sorted().collect(Collectors.toList());
                    if(!lists.contains(collect1)){
                        lists.add(collect1);
                    }
                }
            }
        }
        return lists;
    }*/

    /**
     * 思路： 就是 left左指针往右移动，right右指针往左移动， while(left < right)
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // 跳过可能重复的答案
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        ls.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] < sum) {
                        // 跳过重复值
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        l++;
                    } else {
                        // 跳过重复值
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        r--;
                    }
                }
            }
        }
        return ls;
    }

}
