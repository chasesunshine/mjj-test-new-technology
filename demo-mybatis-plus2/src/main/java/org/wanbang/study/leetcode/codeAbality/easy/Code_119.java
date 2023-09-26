package org.wanbang.study.leetcode.codeAbality.easy;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * 示例 1:
 * 输入: rowIndex = 3
 * 输出: [1,3,3,1]
 *
 * 示例 2:
 * 输入: rowIndex = 0
 * 输出: [1]
 *
 * 示例 3:
 * 输入: rowIndex = 1
 * 输出: [1,1]
 *
 * 提示:
 * 0 <= rowIndex <= 33
 */
public class Code_119 {

    /**
     * 思路：
     * 个人做出来了（但是太耗费空间和时间复杂度）
     * list最后一个和第一个元素都是 1
     * 其余的 用上一个临时 list 把他的 i-1 和i+1个元素加起来
     *
     */
    public static void main(String[] args) {
        List<Integer> row = getRow(3);
        System.out.println(JSON.toJSONString(row));
    }

    public static List<Integer> getRow(int rowIndex) {
        if(rowIndex == 0){
            return Arrays.asList(1);
        }

        int index = 1;
        List<Integer> objects = new ArrayList<>();
        while (index < rowIndex + 1){
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
        }
        return objects;
    }


    public static List<Integer> getRow1(int rowIndex) {
        Integer[] dp = new Integer[rowIndex + 1];
        Arrays.fill(dp,1);
        for(int i = 2;i < dp.length;i++){
            for(int j = i - 1;j > 0;j--)
                dp[j] = dp[j] + dp[j - 1];
        }
        List<Integer> res = Arrays.asList(dp);
        return res;
    }
}
