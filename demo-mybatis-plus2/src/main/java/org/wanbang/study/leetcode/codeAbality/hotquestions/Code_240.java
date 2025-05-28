package org.wanbang.study.leetcode.codeAbality.hotquestions;

import com.alibaba.schedulerx.shade.scala.Int;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * 240. 搜索二维矩阵 II
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *  * 每行的元素从左到右升序排列。
 *  * 每列的元素从上到下升序排列
 *
 * 示例 1：
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 *
 * 示例 2：
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 */
public class Code_240 {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        int target = 19;
        boolean b = searchMatrix(matrix, target);
        System.out.println(b);
    }

    /**
     * 个人思路：
     * 把所有元素放到treeset中
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        Set<Integer> integers = new TreeSet<>();
        for (int i = 0; i < matrix.length; i++) {
            int[] matrix1 = matrix[i];
            for (int j = 0; j < matrix1.length; j++) {
                int i1 = matrix1[j];
                integers.add(i1);
            }
        }
        return integers.contains(target);
    }

    /**
     * 别人思路：
     *
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int m = 0;
        int n = matrix[0].length - 1;
        while (m < matrix.length && n >= 0) {
            if (matrix[m][n] == target) {
                return true;
            } else if (matrix[m][n] > target) {
                n--;
            } else {
                m++;
            }
        }
        return false;
    }
}
