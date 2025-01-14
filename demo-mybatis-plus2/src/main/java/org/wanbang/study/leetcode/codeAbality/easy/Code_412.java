package org.wanbang.study.leetcode.codeAbality.easy;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 412. Fizz Buzz
 * 给你一个整数 n ，找出从 1 到 n 各个整数的 Fizz Buzz 表示，并用字符串数组 answer（下标从 1 开始）返回结果，其中：
 * answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
 * answer[i] == "Fizz" 如果 i 是 3 的倍数。
 * answer[i] == "Buzz" 如果 i 是 5 的倍数。
 * answer[i] == i （以字符串形式）如果上述条件全不满足。
 *
 * 示例 1：
 * 输入：n = 3
 * 输出：["1","2","Fizz"]
 *
 * 示例 2：
 * 输入：n = 5
 * 输出：["1","2","Fizz","4","Buzz"]
 *
 * 示例 3：
 * 输入：n = 15
 * 输出：["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 *
 */
public class Code_412 {
    public static void main(String[] args) {
        List<String> strings = fizzBuzz(15);
        System.out.println(JSON.toJSONString(strings));
    }

    // 自己做出来的
    public static List<String> fizzBuzz(int n) {
        List<String> strings = new ArrayList<>();
        String three = "Fizz";
        String five = "Buzz";
        String threeFive = "FizzBuzz";
        int i = 1;
        while (i <= n){
            if( i%3==0 && i%5==0){
                strings.add(threeFive);
            }else if(i%3==0){
                strings.add(three);
            }else if(i%5==0){
                strings.add(five);
            }else {
                strings.add(String.valueOf(i));
            }
            i++;
        }
        return strings;
    }

}
