package org.wanbang.study.leetcode.codeAbality.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串的长度。在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 *
 * 示例 1:
 *
 * 输入:s = "abccccdd"
 * 输出:7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 *
 * 示例 2:
 * 输入:s = "a"
 * 输出:1
 * 解释：可以构造的最长回文串是"a"，它的长度是 1。
 *
 */
public class Code_409 {
    public static void main(String[] args) {
        String s = "abccccdd";
        int i = longestPalindrome(s);
        System.out.println(i);
    }

    // 自己做出来的
    // 个人思路：
    // 1. 0和1长度的字符串一起处理
    // 2. 统计字符串里面的所有字符个数
    // 3. 字符个数为1的字符串需要作为中间的对称中心（flag标志）
    // 4. 字符个数为奇数的字符串需要作为中间的对称中心（flag标志）
    // 5. 字符个数大于1的需要统计所有字符串之和
    public static int longestPalindrome(String s) {
        if(s.length() <= 1){
            return s.length() ;
        }
        HashMap<Character,Integer> characterHashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(characterHashMap.containsKey(c)){
                Integer value = (Integer) characterHashMap.get(c);
                characterHashMap.put(c,value+1);
            }else {
                characterHashMap.put(c,1);
            }
        }
        Integer sum = 0 ;
        Boolean flag = false;
        for (Map.Entry<Character,Integer> entry:characterHashMap.entrySet()) {
            Integer value = entry.getValue();
            if(value <= 1){
                flag = true;
            }else {
                if(value % 2 == 1){
                    flag = true;
                }
                sum = sum + (value / 2)*2;
            }
        }
        if(flag){
            sum++;
        }
        return sum ;
    }

    // 互相抵消
    public int longestPalindrome1(String s) {
        HashSet<Character> set = new HashSet<>();
        for(int i = 0 ; i < s.length();i++){
            if(set.contains(s.charAt(i))){
                set.remove(s.charAt(i));
            }else
                set.add(s.charAt(i));
        }
        int res = s.length() - set.size();
        return  set.size() == 0 ? res : res + 1;
    }

}
