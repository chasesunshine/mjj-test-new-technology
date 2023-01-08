package org.wanbang.study.leetcode.codeAbality.easy;
/**
* @description: sql
* @author majiajian
* @date 2022/12/16 15:07
* @version 1.0
*/

public class Code_182 {
    /**
     * 思路：
     * 用这个：
     * select email from person group by email having count(email)>1
     *
     * select email as Email from (select email,count(email) as count from Person group by email) a where a.count >1
     */
    public static void main(String[] args) {

    }

}
