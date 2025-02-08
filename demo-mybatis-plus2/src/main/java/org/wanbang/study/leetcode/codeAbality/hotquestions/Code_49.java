package org.wanbang.study.leetcode.codeAbality.hotquestions;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 49. 字母异位词分组
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 *示例 1:
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * 示例 2:
 * 输入: strs = [""]
 * 输出: [[""]]
 *
 * 示例 3:
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 */
public class Code_49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        System.out.println(JSON.toJSONString(lists));
    }

    /**
     * 个人思路：使用一个HashMap，将排序后的元素，放到同一个value的list中
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            // 获取String中所有字符
            char[] temp = strs[i].toCharArray();
            // 将字符进行排序
            Arrays.sort(temp);
            // hashmap中获取排序好的list，没有的话就新建一个list
            List<String> list = map.getOrDefault(new String(temp), new ArrayList<>());
            // 将原始值填入到获取到的list中
            list.add(strs[i]);
            // 将list重新放入到hashmap中
            map.put(new String(temp), list);
        }
        return new ArrayList<>(map.values());
    }
}
