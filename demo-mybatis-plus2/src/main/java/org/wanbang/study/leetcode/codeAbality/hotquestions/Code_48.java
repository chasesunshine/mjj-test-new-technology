package org.wanbang.study.leetcode.codeAbality.hotquestions;

import com.alibaba.fastjson.JSON;

import java.util.*;

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
