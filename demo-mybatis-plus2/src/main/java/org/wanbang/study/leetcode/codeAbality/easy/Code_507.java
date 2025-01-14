package org.wanbang.study.leetcode.codeAbality.easy;

import com.alibaba.schedulerx.shade.scala.Int;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Code_507 {
    public static void main(String[] args) {
        boolean b = checkPerfectNumber(28);
        System.out.println(b);
    }

    /**
     * 个人思路:个人做出来了
     * 要小于平方根
     * 是否整除，整除就放入list中
     *
     * @param num
     * @return
     */
    public static boolean checkPerfectNumber(int num) {
        List<Integer> sum = new ArrayList<>();
        sum.add(1);
        if(num >= 2){
            for (int i = 2; i < Math.sqrt(num) ; i++) {
                if(num % i == 0){
                    Integer value = num / i;
                    sum.add(i);
                    sum.add(value);
                }
            }
        }else {
            return false;
        }
        int sumValue = sum.stream().mapToInt(Integer::intValue).sum();
        return sumValue == num ;
    }
}
