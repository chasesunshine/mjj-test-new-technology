package org.wanbang.study.leetcode.codeAbality.hotquestions;

import com.alibaba.schedulerx.shade.scala.Int;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 41. 缺失的第一个正数
 困难
 相关标签
 相关企业
 提示
 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。

 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。

 示例 1：
 输入：nums = [1,2,0]
 输出：3
 解释：范围 [1,2] 中的数字都在数组中。


 输入：nums = [3,4,-1,1]
 输出：2
 解释：1 在数组中，但 2 没有。

 示例 3：
 输入：nums = [7,8,9,11,12]
 输出：1
 解释：最小的正数 1 没有出现。
 */
public class Code_41 {
    public static void main(String[] args) {
        int[] nums = {1,2,2,1,3,1,0,4,0};
        int i = firstMissingPositive(nums);
        System.out.println(i);
    }

    public static int firstMissingPositive(int[] nums) {
        // 1. 先排序 (还要去重)
        // 2. 判断数组中是否有1
        // 3. 求最小的空缺的不连续的正整数
        Arrays.sort(nums);
        int[] toArray = Arrays.stream(nums).distinct().toArray();

        Integer intervel = Integer.MIN_VALUE;
        int index = 0;
        boolean flag = false;
        while (index < toArray.length){
            if(toArray[index] == 1) flag = true;

            if(toArray[index] < 0 ){
                index ++;
                continue;
            }
            if(intervel != Integer.MIN_VALUE){
                if(intervel + 1 != toArray[index]){
                    intervel = intervel+1;
                    break;
                }else {
                    intervel = toArray[index];
                }
            }else {
                intervel = toArray[index];
            }

            index ++;
        }

        if(intervel < 0){
            return 1;
        }else {
            intervel = intervel == toArray[toArray.length - 1] ? intervel + 1 : intervel;

        }
        return flag?intervel:1;
    }

    public static int firstMissingPositive1(int[] nums) {
        Arrays.sort(nums);
        int res = 1;
        for(int num : nums){
            if(num == res) {
                res++;
            }
        }
        return res;
    }

}
