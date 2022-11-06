package org.wanbang.study.leetcode.codeAbality.easy;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 *示例 1:
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 * 示例 2:
 * 输入: numRows = 1
 * 输出: [[1]]
 *
 * 提示:
 * 1 <= numRows <= 30
 */

public class Code_118 {

    /**
     * 思路：
     * 个人做出来了（但是太耗费空间和时间复杂度）
     * list最后一个和第一个元素都是 1
     * 其余的 用上一个临时 list 把他的 i-1 和i+1个元素加起来
     *
     */
    public static void main(String[] args) {
        List<List<Integer>> generate = generate(3);
        System.out.println(JSON.toJSONString(generate));
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(1));
        if(numRows == 1){
            return lists;
        }

        int index = 1;
        List<Integer> objects = new ArrayList<>();
        while (index < numRows){
            index ++ ;
            List<Integer> objects2 = new ArrayList();
            for (int i = 0; i < index; i++) {
                if(i == 0 || i == index - 1){
                    objects2.add(i,1);
                }else {
                    Integer integer = objects.get(i-1);
                    Integer integer1 = objects.get(i);
                    objects2.add(integer+integer1);
                }
            }
            objects = objects2;
            lists.add(objects2);
        }

        return lists;
    }
}
