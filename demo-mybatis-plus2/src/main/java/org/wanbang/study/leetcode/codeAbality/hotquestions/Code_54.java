package org.wanbang.study.leetcode.codeAbality.hotquestions;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 *示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class Code_54 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        System.out.println(matrix[1][2]);
        List<Integer> integers = spiralOrder(matrix);
        System.out.println(JSON.toJSONString(integers));
    }

    /**
     * 个人没有做出来
     * 设置四个边界，注意状态改变后要增加条件限制，比如后面两个for循环，这个解题是比较好记的，注意每次都是左开右闭就可以了，不要随意更改，其实就是二分查找的区间不变量
     *
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        // 上下左右边界
        int top = 0;
        int bottom = matrix.length-1 ;
        int left = 0;
        int right = matrix[0].length-1;

        while(left<=right&&top<=bottom){
            for(int i = left;i<=right;i++){
                result.add(matrix[top][i]);
            }
            top++;
            for(int i = top;i<=bottom;i++){
                result.add(matrix[i][right]);
            }
            right--;
            for(int i = right;i>=left&&top<=bottom;i--){
                result.add(matrix[bottom][i]);
            }
            bottom--;
            for(int i = bottom;i>=top&&left<=right;i--){
                result.add(matrix[i][left]);
            }
            left++;
        }
        return result;
    }

}
