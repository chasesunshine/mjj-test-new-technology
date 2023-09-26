package org.wanbang.study.leetcode.codeAbality.easy;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:  两个数组的交集 II
 *
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。
 * 返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。
 * 可以不考虑输出结果的顺序。
 *
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 *
 * 示例 2:
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 */
public class Code_350 {
    public static void main(String[] args) {
        int[] ints1 = {4,9,5};
        int[] ints2 = {9,4,9,8,4};
        int[] intersection = intersect(ints1, ints2);

        System.out.println(JSON.toJSONString(intersection));
    }

    /**
     * 个人做出来了，但是感觉复杂了
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> objects = new ArrayList<>();
        Integer[] integers = new Integer[nums2.length];
        for (int i = 0; i < nums2.length; i++) {
            integers[i] = nums2[i];
        }
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < integers.length; j++) {
                if(integers[j] != null && nums1[i] == integers[j]){
                    integers[j] = null;
                    objects.add(nums1[i]);
                    break;
                }
            }
        }

        int[] result = new int[objects.size()];
        for (int i = 0; i < objects.size(); i++) {
            result[i] = objects.get(i);
        }
        return result;
    }

}
