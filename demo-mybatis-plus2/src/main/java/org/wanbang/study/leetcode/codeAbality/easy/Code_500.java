package org.wanbang.study.leetcode.codeAbality.easy;

import com.alibaba.fastjson.JSON;
import com.alibaba.schedulerx.shade.scala.Int;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 500. 键盘行
 *  给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
 * 请注意，字符串 不区分大小写，相同字母的大小写形式都被视为在同一行。
 * 美式键盘 中：
 * 第一行由字符 "qwertyuiop" 组成。
 * 第二行由字符 "asdfghjkl" 组成。
 * 第三行由字符 "zxcvbnm" 组成。
 *
 *
 * 示例 1：
 * 输入：words = ["Hello","Alaska","Dad","Peace"]
 * 输出：["Alaska","Dad"]
 * 解释：
 * 由于不区分大小写，"a" 和 "A" 都在美式键盘的第二行。
 *
 * 示例 2：
 * 输入：words = ["omk"]
 * 输出：[]
 *
 * 示例 3：
 * 输入：words = ["adsdf","sfd"]
 * 输出：["adsdf","sfd"]
 *
 */
public class Code_500 {
    public static void main(String[] args) {
        String[] words = {"omk"};
        String[] words1 = findWords(words);
        System.out.println(JSON.toJSONString(words1));
    }

    /**
     * 个人自己做出来的
     * 用了两层的for循环
     *
     * @param words
     * @return
     */
    public static String[] findWords(String[] words) {
        List<String> objects = new ArrayList<>();
        List<String> getList = new ArrayList<>();
        Map<Character, Integer> integerStringHashMap = new HashMap<>();
        getList.add("qwertyuiop");
        getList.add("asdfghjkl");
        getList.add("zxcvbnm");

        for (int i = 0; i < getList.size(); i++) {
            String s = getList.get(i);
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                integerStringHashMap.put(c,i);
            }
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();
            int point = -1;
            boolean flag = true;
            for (int j = 0; j < word.length(); j++) {
                if(point >= 0){
                    char c = word.charAt(j);
                    Integer integer = integerStringHashMap.get(c);
                    if(integer != point){
                        flag = false;
                        break;
                    }
                }else {
                    char c = word.charAt(j);
                    Integer integer = integerStringHashMap.get(c);
                    point = integer;
                }
            }
            if(flag){
                objects.add(words[i]);
            }
        }
        return objects.toArray(new String[0]);
    }
}
