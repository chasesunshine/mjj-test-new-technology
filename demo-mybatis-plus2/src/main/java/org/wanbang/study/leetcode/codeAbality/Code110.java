package org.wanbang.study.leetcode.codeAbality;

// https://leetcode-cn.com/problems/balanced-binary-tree/

import lombok.extern.slf4j.Slf4j;

/**
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 *
 *
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 *
 *
 * 示例 2：
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 *
 *
 * 示例 3：
 * 输入：root = []
 * 输出：true
 */
@Slf4j
public class Code110 {
    public static void main(String[] args) {
//        TreeNode treeNode15 = new TreeNode(15);
//        TreeNode treeNode7 = new TreeNode(7);
//        TreeNode treeNode20 = new TreeNode(20,treeNode15,treeNode7);
//
//        TreeNode treeNode9 = new TreeNode(9);
//        TreeNode treeNode3 = new TreeNode(9,treeNode9,treeNode20);
//        boolean balanced = isBalanced(treeNode3);

        TreeNode treeNode4_1 = new TreeNode(4);
        TreeNode treeNode4_2 = new TreeNode(4);
        TreeNode treeNode3_1 = new TreeNode(3,treeNode4_1,treeNode4_2);
        TreeNode treeNode3_2 = new TreeNode(3);
        TreeNode treeNode2_1 = new TreeNode(2,treeNode3_1,treeNode3_2);
        TreeNode treeNode2_2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(2,treeNode2_1,treeNode2_2);

        boolean balanced = isBalanced(treeNode1);
        System.out.println(balanced);
    }

    public static boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    // 递归解决，计算子树高度，-1表示子树已经不平衡了
    private static int height(TreeNode root) {
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);

        if(lh >= 0 && rh >= 0 && Math.abs(lh - rh) <= 1) {
            return Math.max(lh, rh) + 1;
        } else {
            return -1;
        }
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {

        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
