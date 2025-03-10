package org.wanbang.study.leetcode.codeAbality.hotquestions;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 示例 1：
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 *
 * 示例 2：
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 */
public class Code_73 {
    public static void main(String[] args) {
        int[][] matrix = {{0}};
        setZeroes(matrix);
        System.out.println(JSON.toJSONString(matrix));
    }

    /**
     *
     * @param matrix
     */
    public static void setZeroes(int[][] matrix) {
        // 个人思路
        // 1. 遍历二维数组，获取 二维数组里面 所有为 0 的数据的横向纵向坐标
        // 2. 横向的坐标和纵向的坐标 存入到两个数组里面(并且去重)
        // 3. 遍历二位数组，每个元素，获取横向纵向的坐标，判断横向坐标和总想坐标是否在 第二步的两个数组里面
        //   在的话就置为0
        List<Integer> hang = new ArrayList<>();
        List<Integer> lie = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int[] width = matrix[i];
            for (int j = 0; j < width.length; j++) {
                int i1 = width[j];
                if(i1 == 0){
                    if(!hang.contains(i)){
                        hang.add(i);
                    }
                    if(!lie.contains(j)){
                        lie.add(j);
                    }
                }
            }
        }
        for (int i = 0; i < matrix.length; i++){
            int[] width = matrix[i];
            for (int j = 0; j < width.length; j++){
                if(lie.contains(j)){
                    matrix[i][j] = 0;
                }
                if(hang.contains(i)){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
