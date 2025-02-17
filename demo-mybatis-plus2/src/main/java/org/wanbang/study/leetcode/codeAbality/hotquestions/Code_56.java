package org.wanbang.study.leetcode.codeAbality.hotquestions;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * 56. 合并区间
 * 中等
 * 相关标签
 * 相关企业
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 */
@Data
public class Code_56 {

    public static void main(String[] args) {
        int[][] intervals  = {{4,5},{2,4},{4,6},{3,4},{0,0},{1,1},{3,5},{2,2}};
        int[][] merge = merge(intervals);
        System.out.println(JSON.toJSONString(merge));
    }

    /**
     * 个人做出来的 思路:
     * // 1. 先要对数组进行排序
     * // 2. 以数组第一个的 end 为比较基准,和后面的数组的 start 作比较
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
        // 1. 先要对数组进行排序
        // 2. 以数组第一个的 end 为比较基准,和后面的数组的 start 作比较

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 比较两个子数组的第一个元素
                return Integer.compare(o1[0], o2[0]);
            }
        });


        Stack<int[]> ints = new Stack<>();
        for (int i = 0; i < intervals.length; i++) {
            if(!ints.isEmpty()){
                int[] pop = ints.peek();
                int start = pop[0];
                int end = pop[1];
                int compareStart = intervals[i][0];
                int compareEnd = intervals[i][1];
                if(end < compareStart ){
                    ints.push(intervals[i]);
                }else {
                    compareEnd = end > compareEnd ? end:compareEnd;
                    int[] value = {start,compareEnd};
                    ints.pop();
                    ints.push(value);
                }
            }else {
                ints.push(intervals[i]);
            }
        }

        int[][] array = new int[ints.size()][2];
        int size = ints.size();
        for (int i = 0; i < size; i++) {
            int[] pop = ints.pop();
            array[size-i-1][0] = pop[0];
            array[size-i-1][1] = pop[1];
        }
        return array;
    }

}
