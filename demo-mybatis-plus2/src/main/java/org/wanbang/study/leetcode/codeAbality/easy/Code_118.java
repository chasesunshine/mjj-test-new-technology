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
    public static void main(String[] args) {
        List<List<Integer>> generate = generate(5);
        System.out.println(JSON.toJSONString(generate));
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        if(numRows == 1){
            lists.add(Arrays.asList(1));
            return lists;
        }
        int count = 1 ;


        return null;
    }
}
