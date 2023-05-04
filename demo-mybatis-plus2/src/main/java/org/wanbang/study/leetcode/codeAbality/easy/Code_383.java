package org.wanbang.study.leetcode.codeAbality.easy;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 赎金信
 *
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 *
 * 示例 1：
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 *
 * 示例 2：
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 *
 * 示例 3：
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 */
public class Code_383 {
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        boolean b = canConstruct(ransomNote, magazine);

        System.out.println(b);
    }

    // 方法一、标准哈希表解决
    public boolean canConstruct1(String ransomNote, String magazine) {
        char[] str1 = ransomNote.toCharArray();
        char[] str2 = magazine.toCharArray();
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(char z : str1){//把ransomNote的值存进哈希表，如果存在相同，则value +1
            if(map.containsKey(z)){
                map.put(z,map.get(z) + 1);
            }else{
                map.put(z,1);
            }
        }

        for(char z : str2){//通过遍历magazine字符来抵消ransomNote字符
            if(map.containsKey(z)){
                map.put(z,map.get(z) - 1);

            }
        }

        for(char z : str1){//因为ransomNote与哈希表key相似，所以通过ransomNote遍历hashmap
            int index = map.get(z);
            if(index > 0){//如果index存在大于0的，说明magazine未能完全抵消ransomNote，即不能由他里面的字符构成
                return false;
            }
        }

        return true;
    }

    /**
     * for(char c : magazine.toCharArray()){
     *             record[c - 'a'] += 1;
     *         }
     *
     * 这地方 就是 26个字母的位置，每个位置都拉出来数据然后 本身+1
     */
    // 方法二、哈希映射数组  - 这个靠谱
    public boolean canConstruct2(String ransomNote, String magazine) {
        // 定义一个哈希映射数组
        int[] record = new int[26];

        // 遍历
        for(char c : magazine.toCharArray()){
            record[c - 'a'] += 1;
        }

        for(char c : ransomNote.toCharArray()){
            record[c - 'a'] -= 1;
        }

        // 如果数组中存在负数，说明ransomNote字符串总存在magazine中没有的字符
        for(int i : record){
            if(i < 0){
                return false;
            }
        }

        return true;
    }

    // 方法三、暴力
    public boolean canConstruct3(String ransomNote, String magazine) {
        char[] str1 = ransomNote.toCharArray();
        char[] str2 = magazine.toCharArray();
        for(int i = 0;i < str1.length;i++){//若满足题目要求，magazine必定包括ransomNote
            for(int j = 0;j < str2.length;j++){
                if(str1[i] == str2[j]){
                    str1[i] = '0';
                    str2[j] = '0';
                    continue;
                }
            }
        }

        for(int i = 0;i < str1.length;i++){//如满足题目，str1中的元素必定全为0
            if(str1[i] != '0'){
                return false;
            }
        }

        return true;

    }





    /**
     * 没做出来 - 看不懂
     *
     * 方法一：字符统计
     * 题目要求使用字符串 magazine 中的字符来构建新的字符串 ransomNote，
     * 且 ransomNote中的每个字符只能使用一次，只需要满足字符串 magazine
     * 中的每个英文字母 (’a’-’z’) 的统计次数都大于等于
     * ransomNote 中相同字母的统计次数即可。
     *
     * 如果字符串 magazine 的长度小于字符串
     * ransomNote 的长度，则我们可以肯定 magazine
     * 无法构成 ransomNote，此时直接返回 false
     * 首先统计 magazine 中每个英文字母 a 的次数 cnt[a]
     * 再遍历统计 ransomNote 中每个英文字母的次数，
     * 如果发现 ransomNote 中存在某个英文字母 c 的统计次数大于
     * magazine 中该字母统计次数 cnt[c]
     * 则此时我们直接返回 false
     *
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }
        System.out.println(JSON.toJSONString(cnt));
        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if(cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}