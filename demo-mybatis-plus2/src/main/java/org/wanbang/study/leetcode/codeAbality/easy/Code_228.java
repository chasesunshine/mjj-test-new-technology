package org.wanbang.study.leetcode.codeAbality.easy;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个  无重复元素 的 有序 整数数组 nums 。
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *
 * 示例 1：
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 *
 * 示例 2：
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 */

public class Code_228 {
    /**
     * 思路：
     * 外层的指针不动，内层做判断，并且指针不停往后叠加
     * 利用stringBuffer内层不停追加
     */
    public static void main(String[] args) {
        int[] ints = {0, 1, 2, 4, 5, 7};
        List<String> strings = summaryRanges(ints);

        System.out.println(JSON.toJSONString(strings));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            StringBuilder sb = new StringBuilder();
            int temp = i;
            while (i < nums.length-1 && nums[i]+1 == nums[i+1]){
                i++;
            }
            if (i == temp){
                sb.append(nums[i]);
            }else {
                sb.append(nums[temp]);
                sb.append("->");
                sb.append(nums[i]);
            }
            list.add(sb.toString());
        }
        return list;
    }
}
