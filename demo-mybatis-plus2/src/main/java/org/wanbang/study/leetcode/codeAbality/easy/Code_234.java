package org.wanbang.study.leetcode.codeAbality.easy;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Stack;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：head = [1,2,2,1]
 * 输出：true
 *
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：false
 */

public class Code_234 {
    /**
     * 思路：
     * （简单暴力）先循环一遍，将值保存到栈中，再次循环列表与出栈的值比较
     */
    public static void main(String[] args) {
        ListNode listNode = new ListNode();
//        listNode.setVal(1).setNext(
//                new ListNode().setVal(2).setNext(
//                        new ListNode().setVal(2).setNext(
//                                new ListNode().setVal(1).setNext(null)
//                        )));
        listNode.setVal(1).setNext(
                new ListNode().setVal(2).setNext(null));
        boolean palindrome = isPalindrome(listNode);
        System.out.println(palindrome);
    }

    public static boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode originalHead = head;
        Stack<Integer> integers = new Stack<>();
        while (head != null){
            int val = head.val;
            integers.push(val);
            head = head.next;
        }
        while (originalHead != null){
            int val = originalHead.val;
            Integer pop = integers.pop();
            if(val != pop){
                return false;
            }
            originalHead = originalHead.next;
        }
        return true;
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
