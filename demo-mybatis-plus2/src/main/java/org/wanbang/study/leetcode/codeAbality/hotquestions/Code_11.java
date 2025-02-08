package org.wanbang.study.leetcode.codeAbality.hotquestions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 11. 盛最多水的容器
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 *
 * 示例 1：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 *
 */
public class Code_11 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int i = maxArea(height);
        System.out.println(i);
    }


    /**
     * 个人做法： 超出内存限制
     *
     *
     * @param height
     * @return
     */
    /*public static int maxArea(int[] height) {
        if(height.length < 2){
            return 0;
        }
        if(height.length == 2){
            int min = height[0] > height[1] ? height[1]:height[0];
            return min * min;
        }
        List<Integer> valueList = new ArrayList<>();
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length;j++) {
                int wide = j-i;
                int min = height[j] <= height[i] ? height[j]:height[i];
                int value = wide * min;
                valueList.add(value);
            }
        }
        List<Integer> collect = valueList.stream().sorted((a,b)->b-a).collect(Collectors.toList());

        return collect.get(0);
    }*/

    public static int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            // 当左边高度小于右边高度的时候
            if (height[left] < height[right]) {
                // 右边减去左边 获取宽度 * 左边的高度
                max = Math.max(max, (right - left) * height[left]);
                left++;
            } else {
                // 右边减去左边 获取宽度 * 右边的高度
                max = Math.max(max, (right - left) * height[right]);
                right--;
            }
        }
        return max;
    }

}
