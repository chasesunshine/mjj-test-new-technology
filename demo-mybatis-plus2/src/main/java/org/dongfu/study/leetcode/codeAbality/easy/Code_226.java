package org.dongfu.study.leetcode.codeAbality.easy;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 * 示例 2：
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 *
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 */

public class Code_226 {
    /**
     * 思路：
     * 可以发现想要翻转它，其实就把每一个节点的左右孩子交换一下就可以了。
     * 关键在于遍历顺序，前中后序应该选哪一种遍历顺序？ （一些同学这道题都过了，但是不知道自己用的是什么顺序）
     * 遍历的过程中去翻转每一个节点的左右孩子就可以达到整体翻转的效果。
     *
     * 注意只要把每一个节点的左右孩子翻转一下，就可以达到整体翻转的效果
     * 这道题目使用前序遍历和后序遍历都可以，唯独中序遍历不方便，因为中序遍历会把某些节点的左右孩子翻转了两次！建议拿纸画一画，就理解了
     * 那么层序遍历可以不可以呢？依然可以的！只要把每一个节点的左右孩子翻转一下的遍历方式都是可以的！
     */
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode().setVal(4)
                .setLeft(new TreeNode().setVal(2)
                        .setLeft(new TreeNode().setVal(1))
                        .setRight(new TreeNode().setVal(3))
                )
                .setRight(new TreeNode().setVal(7)
                        .setLeft(new TreeNode().setVal(6))
                        .setRight(new TreeNode().setVal(9))
                );

        TreeNode treeNode1 = invertTree(treeNode);

        System.out.println(JSON.toJSONString(treeNode1));
    }

    public static TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        swapChildren(root);
        return root;
    }

    private static void swapChildren(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
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
