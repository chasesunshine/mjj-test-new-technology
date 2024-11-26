package org.wanbang.study.leetcode.codeAbality.easy;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * 414. 第三大的数
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 *
 * 示例 1：
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 *
 * 示例 2：
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 *
 * 示例 3：
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * 解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
 * 此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1
 * 。
 */
public class Code_414 {
    public static void main(String[] args) {
        int[] ints = {1,1,2};
        int i = thirdMax(ints);
        System.out.println(i);
    }

    // 个人做法，
    // 先从大到小排序
    // 将不重复的数字塞到 有序集合中
    // 排完之后取出第三大的
    public static int thirdMax(int[] nums) {
        LinkedHashSet<Integer> integers = new LinkedHashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] >= nums[i]){
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
            integers.add(nums[i]);
        }
        if(nums.length >= 3){
            List<Integer> value = new ArrayList<>(integers);
            return value.size() >= 3 ? value.get(2):value.get(0);
        }else {
            return nums[0];
        }
    }

}
