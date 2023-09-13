package org.dongfu.study.leetcode.codeAbality;

// https://leetcode-cn.com/problems/monotonic-array/

import lombok.extern.slf4j.Slf4j;

/**
 * 896. 单调数列
 * 如果数组是单调递增或单调递减的，那么它是 单调 的。
 *
 * 如果对于所有 i <= j，nums[i] <= nums[j]，那么数组 nums 是单调递增的。 如果对于所有 i <= j，nums[i]> = nums[j]，那么数组 nums 是单调递减的。
 *
 * 当给定的数组 nums 是单调数组时返回 true，否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2,3]
 * 输出：true
 * 示例 2：
 *
 * 输入：nums = [6,5,4,4]
 * 输出：true
 * 示例 3：
 *
 * 输入：nums = [1,3,2]
 * 输出：false
 */
@Slf4j
public class Code896 {
    public static void main(String[] args) {
        log.info("先判断第一个元素和最后一个元素的大小关系，确定数组是升序还是降序。");
        int[] ints = {1,2,2,3};
        boolean monotonic = isMonotonic(ints);
        System.out.println(monotonic);
    }

    public static boolean isMonotonic(int[] A) {
        if(A.length == 1){
            return true;
        }

        if(A[0] <= A[A.length-1]){
            for(int i=0;i<A.length-1;i++){
                if(A[i] > A[i+1])
                    return false;
            }
        }else{
            for(int i=0;i<A.length-1;i++){
                if(A[i] < A[i+1])
                    return false;
            }
        }

        return true;
    }

}
