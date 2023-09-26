package org.wanbang.study.leetcode.codeAbality.easy;
/**
* @description: sql
* @author majiajian
* @date 2022/12/16 18:25
* @version 1.0
*/

public class Code_183 {
    /**
     * 思路：
     * 用这个：select Name Customers from Customers c where not exists(select * from Orders o where o.CustomerId=c.Id)
     *
     * 个人：select a.name as from  (select c.id,c.name,o.CustomerId from Customers c left join Orders o on c.id = o.CustomerId) a where a.CustomerId is null;
     */
    public static void main(String[] args) {

    }
}
