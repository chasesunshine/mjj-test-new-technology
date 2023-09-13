package org.dongfu.study.leetcode.codeAbality.easy;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 *
 * 示例 1：
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 *
 * 示例 2：
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 *
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 *
 */

public class Code_83 {
    /**
     * 思路：
     * 递归套路解决链表问题：
     *
     * 找终止条件：当head指向链表只剩一个元素的时候，自然是不可能重复的，因此return
     * 想想应该返回什么值：应该返回的自然是已经去重的链表的头节点
     * 每一步要做什么：宏观上考虑，此时head.next已经指向一个去重的链表了，而根据第二步，我应该返回一个去重的链表的头节点。因此这一步应该做的是判断当前的head和head.next是否相等，如果相等则说明重了，返回head.next，否则返回head
     * 如果独立写递归函数有困难的，可以参考一下我写的一个博客，附有详细的图文介绍：博客链接
     */
    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        listNode.setVal(1).setNext(
                new ListNode().setVal(2).setNext(
                        new ListNode().setVal(2).setNext(
                                new ListNode().setVal(3).setNext(null)
                        )));

        ListNode listNode1 = deleteDuplicates(listNode);
        System.out.println(JSON.toJSONString(listNode1));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        head.next = deleteDuplicates(head.next);
        if(head.val == head.next.val) head = head.next;
        return head;
    }

    @Accessors(chain = true)
    @Data
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }
}
