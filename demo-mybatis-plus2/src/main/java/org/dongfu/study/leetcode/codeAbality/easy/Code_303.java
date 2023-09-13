package org.dongfu.study.leetcode.codeAbality.easy;

/**
 * 看不懂 - 暂时放弃
 */

public class Code_303 {
    public static void main(String[] args) {

    }

    private int[] sums;

    public Code_303(int[] nums) {
        sums = new int[nums.length];
        if (nums.length == 0) {
            return;
        }
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] += sums[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return sums[j];
        } else {
            return sums[j] - sums[i - 1];
        }
    }
}
