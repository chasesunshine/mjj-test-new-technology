package org.wanbang.study.leetcode.codeAbality.easy;
/**
* @description: https://leetcode.cn/problems/two-sum/
* @author majiajian
* @date 2022/10/20 13:30
* @version 1.0
*/

import com.alibaba.schedulerx.shade.scala.Int;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，
 * 并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 *
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *  
 *
 * 提示：
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 *
 *
 */

public class Code1 {
    public static void main(String[] args) {
        int[] ints = new int[]{1,2,7,2,5};
        int target = 6;
        int[] ints1 = twoSum(ints, target);
        System.out.println(Arrays.toString(ints1));
    }

    /**
     *
     * 思路：
     * 把 补值和遍历的下标放到 放到 hashmap
     * 然后遍历 num 的时候 找到补值，然后取出对应的 下标和存到map里面的下标
     *
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] indexs = new int[2];

        // 建立k-v ，一一对应的哈希表
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(nums[i])){
                indexs[0] = i;
                indexs[1] = hash.get(nums[i]);
                return indexs;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target-nums[i],i);
        }

        return indexs;
    }
}
