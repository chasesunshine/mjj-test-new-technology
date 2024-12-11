package org.wanbang.study.leetcode.codeAbality.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 506. 相对名次
 * 给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。
 * 运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，依此类推。运动员的名次决定了他们的获奖情况：
 * 名次第 1 的运动员获金牌 "Gold Medal" 。
 * 名次第 2 的运动员获银牌 "Silver Medal" 。
 * 名次第 3 的运动员获铜牌 "Bronze Medal" 。
 * 从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。
 * 使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。
 *
 * 示例 1：
 * 输入：score = [5,4,3,2,1]
 * 输出：["Gold Medal","Silver Medal","Bronze Medal","4","5"]
 * 解释：名次为 [1st, 2nd, 3rd, 4th, 5th] 。
 *
 * 示例 2：
 * 输入：score = [10,3,8,9,4]
 * 输出：["Gold Medal","5","Bronze Medal","Silver Medal","4"]
 * 解释：名次为 [1st, 5th, 3rd, 2nd, 4th] 。
 *
 */
public class Code_506 {
    public static void main(String[] args) {
        int[] value= {5,4,3,2,1};
        String[] relativeRanks = findRelativeRanks(value);
        System.out.println(Arrays.toString(relativeRanks));
    }

    /**
     * 个人思路：从大到小进行排序
     * 然后把这些值放进hashmap中，key为值，value为名次
     *
     * @param score
     * @return
     */
    public static String[] findRelativeRanks(int[] score) {
        String[] result = Arrays.stream(score)
                .mapToObj(Integer::toString)
                .toArray(String[]::new);

        // 从大到小排列
        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score.length - i -1; j++) {
                //判断当前数是否比后面数大
                if(score[j] < score[j+1]) {
                    int temp=score[j];
                    score[j]=score[j+1];
                    score[j+1]=temp;
                }
            }
        }

        HashMap<String, Integer> objectObjectHashMap = new HashMap<>();
        for (int i = 0; i < score.length; i++) {
            objectObjectHashMap.put(String.valueOf(score[i]),i+1);
        }

        for (int i = 0; i < result.length; i++) {
            Integer integer = objectObjectHashMap.get(result[i]);
            if(integer == 1){
                result[i] = "Gold Medal";
            }else if(integer == 2){
                result[i] = "Silver Medal";
            }else if(integer == 3){
                result[i] = "Bronze Medal";
            }else {
                result[i] = integer.toString();
            }
        }

        return result;
    }
}
