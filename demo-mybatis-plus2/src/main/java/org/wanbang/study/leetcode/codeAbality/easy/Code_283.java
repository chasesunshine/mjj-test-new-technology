package org.wanbang.study.leetcode.codeAbality.easy;

import com.alibaba.fastjson.JSON;

/**
 *给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 示例 2:
 * 输入: nums = [0]
 * 输出: [0]
 *
 */

public class Code_283 {
    /**
     * 思路:
     * 一定要反过来想,不要只盯着0,可以设置一个指针,就是专业收集不是零的数 收集一遍后,后面的一定是0,
     * 就再将空出来的位置设置为0,就解决问题了
     */
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);

        System.out.println(JSON.toJSONString(nums));
    }

    public static void moveZeroes(int[] nums){
        //定义收集不是0的数的指针
        int s=0;
        //开始收集不是零的数
        for (int i = 0; i < nums.length ;i++) {
            if(nums[i]!=0){
                nums[s] = nums[i];
                s++;
            }
        }
        //收集完毕后,后面自然就都是0了
        for (int i = s; i < nums.length; i++) {
            nums[i]=0;
        }
    }


    public static void moveZeroes1(int[] nums) {
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(i == index ){
                break;
            }
            if(num == 0){
                for (int j = nums.length - 1; j >= 0  ; j--) {
                    int num1 = nums[j];
                    if(num1 != 0){
                        nums[i] = num1;
                        nums[j] = num;
                        index = j;
                        break;
                    }
                }

            }
        }
    }
}
