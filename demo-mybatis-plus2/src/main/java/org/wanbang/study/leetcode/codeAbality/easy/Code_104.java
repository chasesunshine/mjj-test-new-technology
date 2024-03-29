package org.wanbang.study.leetcode.codeAbality.easy;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 */

public class Code_104 {
    /**
     * 思路：
     * 递归
     */
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode().setVal(3)
                .setLeft(new TreeNode().setVal(9))
                .setRight(new TreeNode().setVal(20)
                        .setLeft(new TreeNode().setVal(15).setLeft(null).setRight(null))
                        .setRight(new TreeNode().setVal(7).setLeft(null).setRight(null)));
        int i = maxDepth(treeNode);

        System.out.println(i);
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
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
