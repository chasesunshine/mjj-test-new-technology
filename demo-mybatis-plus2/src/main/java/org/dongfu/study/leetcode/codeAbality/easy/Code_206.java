package org.dongfu.study.leetcode.codeAbality.easy;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 *
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 *
 * 示例 3：
 * 输入：head
 */

public class Code_206 {
    /**
     * 思路：
     * 对于单链表，反转时需要三个指针分别指向前中后三个结点，
     * 中间结点的next指向前结点完成中间结点的反转，
     * 后指针指向中间结点的原后继，防止链表丢失
     */
    public static void main(String[] args) {
        ListNode listNode = new ListNode().setVal(1).setNext(
                new ListNode().setVal(2).setNext(
                        new ListNode().setVal(3).setNext(
                                new ListNode().setVal(4).setNext(
                                        new ListNode().setVal(5).setNext(null)
                                ))));
        ListNode listNode1 = reverseList(listNode);

        System.out.println(JSON.toJSONString(listNode1));
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre =  null;
        ListNode cur =  head;
        ListNode next;

        while (cur != null){
            // 保存 当前结点 下一个节点
            next = cur.next;
            // 改变 当前节点 下一节点的数据
            cur.next = pre;
            // 将改变的节点 赋值给 最终的目的链表
            pre = cur;
            // 获取到下一个节点 ， while循环遍历下一个节点
            cur = next;
        }
        // 最后一次迭代 pre 指向尾结点
        return pre;
    }

    @NoArgsConstructor
    @Data
    @Accessors(chain = true)
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
