package org.wanbang.study.leetcode.codeAbality.hotquestions;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 48. 旋转图像
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 *
 *示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 *
 *
 * 示例 2：
 * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 *
 */
public class Code_48 {

    public static void main(String[] args) {
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(matrix);
        System.out.println(JSON.toJSONString(matrix));
    }


    public static void rotate(int[][] matrix) {
        Queue<Integer> integers = new ArrayDeque<>();

        // 上下左右边界
        int top = 0;
        int bottom = matrix.length-1 ;
        int left = 0;
        int right = matrix[0].length-1;

        while ( top<=bottom && left<=right){
            for (int i = bottom ; i >= top ; i--){
                integers.add(matrix[i][left]);
            }
            left ++;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = integers.poll();
            }
        }
    }
}
