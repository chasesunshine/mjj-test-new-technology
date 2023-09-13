package org.dongfu.study.leetcode.codeAbality.easy;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 *给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * 示例 1：
 *输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 *
 * 示例 2：
 * 输入：head = [], val = 1
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 */

public class Code_203 {
    /**
     * 思路:
     * 方法一：递归
     * 链表的定义具有递归的性质，因此链表题目常可以用递归的方法求解。这道题要求删除链表中所有节点值等于特定值的节点，可以用递归实现。
     * 对于给定的链表，首先对除了头节点 head\textit{head}head 以外的节点进行删除操作，然后判断 head\textit{head}head 的节点值是否等于给定的 val\textit{val}val。如果 head\textit{head}head 的节点值等于 val\textit{val}val，则 head\textit{head}head 需要被删除，因此删除操作后的头节点为 head.next\textit{head}.\textit{next}head.next；如果 head\textit{head}head 的节点值不等于 val\textit{val}val，则 head\textit{head}head 保留，因此删除操作后的头节点还是 head\textit{head}head。上述过程是一个递归的过程。
     * 递归的终止条件是 head\textit{head}head 为空，此时直接返回 head\textit{head}head。当 head\textit{head}head 不为空时，递归地进行删除操作，然后判断 head\textit{head}head 的节点值是否等于 val\textit{val}val 并决定是否要删除 head\textit{head}head。
     *
     */
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode().setVal(4).setNext(
                new ListNode().setVal(1).setNext(
                        new ListNode().setVal(8).setNext(
                                new ListNode().setVal(4).setNext(
                                        new ListNode().setVal(5).setNext(null)
                                ))));
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    @Data
    @Accessors(chain = true)
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }




}

