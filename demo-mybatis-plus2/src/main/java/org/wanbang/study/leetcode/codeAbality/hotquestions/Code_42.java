package org.wanbang.study.leetcode.codeAbality.hotquestions;

/**
 * 42. 接雨水
 * 困难
 * 相关标签
 * 相关企业
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 * 示例 2：
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 */
public class Code_42 {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = trap(height);
        System.out.println(trap);
    }

    /**
     * 思路： 每个柱子能盛水的深度，取决于min(左边最高，右边最高），即res[i] = min(l_max[i], r_max[i]) - height[i];
     * 个人做法： 个人已经做出来了 , 超出时间限制
     *
     *
     * @param height
     * @return
     */
   /* public static int trap(int[] height) {
        int sum = 0;
        for (int i = 1; i < height.length; i++) {
            int left = i;
            int leftMax = height[i];
            int right = i;
            int rightMax = height[i];

            while (left >= 0){
                leftMax = Math.max(height[left],leftMax);
                left--;
            }

            while (right <= height.length - 1){
                rightMax = Math.max(height[right],rightMax);
                right++;
            }

            int min = Math.min(leftMax,rightMax);;
            sum = sum +(min - height[i]);
        }
        return sum;
    }*/


    public static int trap(int[] height) {
        int min = 0;
        int max = 0;
        int l = 0;
        int r = height.length-1;

        int res = 0;

        while(l < r){
            int i = height[l] < height[r] ? l++ : r--;
            min = height[i];
            max = Math.max(min,max);
            res += max - min;
        }
        return res;
    }
}
