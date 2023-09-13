package org.dongfu.study.leetcode.codeAbality.easy;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 *
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 *
 * 示例 4：
 * 输入：root = [1,2]
 * 输出：[1,2]
 *
 * 示例 5：
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *
 * 提示：
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 */

public class Code_144 {

    /**
     * 思路：
     * 用栈的思路
     */
    public static void main(String[] args) {
        //                  1
        //          2       |      2
        //      3   |   4        4  |  3
        //    5  6  | 7

        //  [1, 2, 3, 5, 6, 4, 7, 2, 4, 3]
        TreeNode treeNode = new TreeNode().setVal(1)
                .setLeft(new TreeNode().setVal(2)
                        .setLeft(new TreeNode().setVal(3)
                                .setLeft(new TreeNode().setVal(5))
                                .setRight(new TreeNode().setVal(6)))
                        .setRight(new TreeNode().setVal(4)
                                .setLeft(new TreeNode().setVal(7))
                                .setRight(null)))
                .setRight(new TreeNode().setVal(2)
                        .setLeft(new TreeNode().setVal(4).setLeft(null).setRight(null))
                        .setRight(new TreeNode().setVal(3).setLeft(null).setRight(null)));

        List<Integer> integers = preorderTraversal(treeNode);
        System.out.println(integers);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> integers = preOrder(root);
        return integers;
    }

    //前序
    public static List<Integer> preOrder(TreeNode root){
        List<Integer> list = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        while(cur!=null || !stack.isEmpty()){
            //一直往左压入栈
            while(cur!=null){
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return list;
    }

    @Data
    @Accessors(chain = true)
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}

