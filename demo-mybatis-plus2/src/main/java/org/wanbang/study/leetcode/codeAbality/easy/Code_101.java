package org.wanbang.study.leetcode.codeAbality.easy;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 *
 * 示例 2：
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *  
 *
 * 提示：
 *
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 *  
 */

public class Code_101 {

    /**
     * 思路：
     * 递归解法
     */
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode().setVal(1).
                setLeft(new TreeNode().setVal(2)
                        .setLeft(new TreeNode().setVal(3).setLeft(null).setRight(null))
                        .setRight(new TreeNode().setVal(4).setLeft(null).setRight(null)))
                .setRight(new TreeNode().setVal(2)
                        .setLeft(new TreeNode().setVal(4).setLeft(null).setRight(null))
                        .setRight(new TreeNode().setVal(3).setLeft(null).setRight(null)));

        boolean symmetric = isSymmetric(treeNode);
        System.out.println(symmetric);
    }

    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return cmp(root.left,root.right);
    }

    private static boolean cmp(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null)return true;
        if(node1 == null)return false;
        if(node2 == null)return false;
        if(node1.val == node2.val){
            return cmp(node1.left,node2.right) && cmp(node1.right, node2.left);
        }else{
            return false;
        }
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
