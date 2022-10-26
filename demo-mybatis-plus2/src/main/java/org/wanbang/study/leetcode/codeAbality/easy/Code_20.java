package org.wanbang.study.leetcode.codeAbality.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *  
 *
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 *  
 *
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 *
 */

public class Code_20 {

    /**
     * 思路：
     * (栈：先进后出)
     * java，建立一个新的栈，然后遍历字符串的字符，进行比较
     */
    public static void main(String[] args) {
        String s = "{([])}";
        boolean valid = isValid(s);
        boolean valid1 = isValid1(s);
        System.out.println(valid);
        System.out.println(valid1);
    }

    public static boolean isValid(String s) {
        int length = s.length() / 2;
        for (int i = 0; i < length; i++) {
            s = s.replace("()", "")
                    .replace("{}", "")
                    .replace("[]", "");
        }

        return s.length() == 0;
    }

    //这个思路好，用这个 ，时间复杂度小
    public static boolean isValid1(String s) {
        Stack<Character>stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(c=='(')stack.push(')');
            else if(c=='[')stack.push(']');
            else if(c=='{')stack.push('}');
            else {
                Character pop = stack.pop();
                boolean b1 = c != pop;
                boolean b2 = stack.isEmpty();
                boolean b = b2 || b1;
                if(b){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
