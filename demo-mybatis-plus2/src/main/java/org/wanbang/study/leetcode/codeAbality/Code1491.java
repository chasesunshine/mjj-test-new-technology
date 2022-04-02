package org.wanbang.study.leetcode.codeAbality;

// https://leetcode-cn.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/

import java.math.BigDecimal;

/**
 * 1491. 去掉最低工资和最高工资后的工资平均值
 * 给你一个整数数组 salary ，数组里每个数都是 唯一 的，其中 salary[i] 是第 i 个员工的工资。
 *
 * 请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：salary = [4000,3000,1000,2000]
 * 输出：2500.00000
 * 解释：最低工资和最高工资分别是 1000 和 4000 。
 * 去掉最低工资和最高工资以后的平均工资是 (2000+3000)/2= 2500
 */
public class Code1491 {
    public static void main(String[] args) {
        int[] ints = new int[]{4000,3000,1000,2000};
        double average = average(ints);
        System.out.println(average);
    }

    public static double average(int[] salary) {
        int sum = 0;
        int lowValue = salary[0];
        int hignValue = salary[0];
        for (int i = 0; i < salary.length; i++) {
            if(lowValue >= salary[i]){
                lowValue = salary[i];
            }
            if(hignValue <= salary[i]){
                hignValue = salary[i];
            }
            sum = sum + salary[i];
        }
        double length = (salary.length - 2);
        double sumValue = (sum - lowValue - hignValue);
        double average = sumValue/length;
        return average;
    }
}
