package org.dongfu.study.leetcode.codeAbality.easy;

import com.alibaba.fastjson.JSON;
import com.alibaba.schedulerx.shade.scala.Int;

import java.util.HashSet;

/**
 * @description:  两个数组的交集
 *
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。
 * 我们可以 不考虑输出结果的顺序 。
 *
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 *
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 */
public class Code_349 {
    public static void main(String[] args) {
        int[] ints1 = {4,9,5};
        int[] ints2 = {9,4,9,8,4};
        int[] intersection = intersection(ints1, ints2);

        System.out.println(JSON.toJSONString(intersection));
    }

    /**
     * 个人利用hashset不允许重复的思想
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> objects = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if(nums2[j] == nums1[i]){
                    objects.add(nums1[i]);
                }
            }
        }
        Object[] ins = objects.toArray();
        int[] i = new int[ins.length];
        for(int k=0;k<ins.length;k++){
            i[k] = Integer.parseInt(ins[k].toString());
        }
        return i;
    }

}
