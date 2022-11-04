package org.wanbang.study.leetcode.codeAbality.easy;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 *
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 *
 *示例 2：
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 *
 * 提示：
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 *
 */

public class Code_111 {

    /**
     * 思路：
     *递归
     */
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode().setVal(3)
                .setLeft(new TreeNode().setVal(9))
                .setRight(new TreeNode().setVal(20)
                        .setLeft(new TreeNode().setVal(15))
                        .setRight(new TreeNode().setVal(7))
                );

        int i = minDepth(treeNode);
        System.out.println(i);
    }

    public static int minDepth1(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return 1;
        if(root.left!=null && root.right!=null)
            return Math.min(minDepth(root.left),minDepth(root.right))+1;
        if(root.left!=null)
            return minDepth(root.left)+1;
        if(root.right!=null)
            return minDepth(root.right)+1;
        return 1;
    }

    public static int minDepth(TreeNode root) {
        if(root==null) return 0;//遇到节点为空的就返回
        int leftDepth = minDepth(root.left);//计算左子树的最小深度
        int rightDepth = minDepth(root.right);//计算右子树的最小深度
        //特殊情况1: 当节点左子树为空,右子树不为空,这时最小深度肯定不是0,而是对应的右子树的最小深度加1
        if(root.left!=null&&root.right==null){
            return leftDepth+1;
        }
        //特殊情况2:当节点右子树为空,左子树不为空,这时最小深度肯定不是0,而是对应的左子树的最小深度加1
        if(root.left==null&&root.right!=null){
            return rightDepth+1;
        }
        //当左右子树都不为空是要求的是两个子树的最小高度
        return Math.min(leftDepth,rightDepth)+1;
    }

    @Data
    @Accessors(chain = true)
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