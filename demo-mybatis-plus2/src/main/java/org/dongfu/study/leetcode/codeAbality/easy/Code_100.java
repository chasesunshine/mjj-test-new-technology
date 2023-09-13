package org.dongfu.study.leetcode.codeAbality.easy;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Stack;

/**
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1：
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 *
 * 示例 2：
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 *
 * 示例 3：
 * 输入：p = [1,2,1], q = [1,1,2]
 * 输出：false
 *
 * 提示：
 *
 * 两棵树上的节点数目都在范围 [0, 100] 内
 * -104 <= Node.val <= 104
 */

public class Code_100 {

    /**
     * 思路：
     * 递归解法
     */
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode().setVal(1).
                setLeft(new TreeNode().setVal(2).setLeft(null))
                .setRight(new TreeNode().setVal(3).setLeft(null));
        TreeNode treeNode2 = new TreeNode().setVal(1).
                setLeft(new TreeNode().setVal(2).setLeft(null))
                .setRight(new TreeNode().setVal(3).setLeft(null));
        boolean sameTree = isSameTree(treeNode1, treeNode2);
        System.out.println(sameTree);
    }

    /**
     * 二叉树节点
     */
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


    /**
     * 递归解法
     *
     * @param p
     * @param q
     * @return
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null) return false;
        if (q == null) return false;
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }

    /**
     * 非递归前序遍历判断相等
     * 根左右
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTreePre(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null) return false;
        if (q == null) return false;
        Stack<TreeNode> stackP = new Stack<>();
        stackP.add(p);
        Stack<TreeNode> stackQ = new Stack<>();
        stackQ.add(q);
        while (!stackP.isEmpty() || !stackQ.isEmpty()) {
            TreeNode pNode = stackP.pop();
            TreeNode qNode = stackQ.pop();
            if (pNode == null && qNode == null) continue;
            if (pNode == null) return false;
            if (qNode == null) return false;
            if (pNode.val != qNode.val) {
                return false;
            } else {
                stackP.add(pNode.right);
                stackQ.add(qNode.right);
                stackP.add(pNode.left);
                stackQ.add(qNode.left);
            }
        }
        return true;
    }

    /**
     * 非递归中序遍历判断两棵二叉树是否相等
     * 左根右
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTreeMid(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null) return false;
        if (q == null) return false;
        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();
        while (p != null || q != null || !stackP.isEmpty() || !stackQ.isEmpty()) {
            if (p != null && q != null) {
                stackP.add(p);
                stackQ.add(q);
                p = p.left;
                q = q.left;
            } else if (q == null && p == null) {
                p = stackP.pop();
                q = stackQ.pop();
                if (p.val != q.val) {
                    return false;
                }
                p = p.right;
                q = q.right;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 二叉树后序遍历判断两颗树相等
     * 左右根
     * 双栈解法
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTreeEnd1(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null) return false;
        if (q == null) return false;
        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackPTmp = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();
        Stack<TreeNode> stackQTmp = new Stack<>();
        while (p != null || q != null || !stackPTmp.isEmpty() || !stackQTmp.isEmpty()) {
            if (p != null && q != null) {
                stackP.add(p);
                stackPTmp.add(p);
                stackQ.add(q);
                stackQTmp.add(p);
                p = p.right;
                q = q.right;
            } else if (p == null && q == null) {
                p = stackPTmp.pop();
                p = p.left;
                q = stackQTmp.pop();
                q = q.left;
            } else {
                return false;
            }
        }

        while (!stackP.isEmpty() && !stackQ.isEmpty()) {
            if (stackP.pop().val != stackQ.pop().val) {
                return false;
            }
        }

        return true;
    }

    /**
     * 二叉树后序遍历单栈实现对比判断
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTreeEnd2(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null) return false;
        if (q == null) return false;
        Stack<TreeNode> stackP = new Stack<>();
        stackP.add(p);
        TreeNode pPre = null;
        Stack<TreeNode> stackQ = new Stack<>();
        stackQ.add(q);
        TreeNode qPre = null;
        while (!stackP.isEmpty() || !stackQ.isEmpty()) {
            p = stackP.peek();
            q = stackQ.peek();
            if (((pPre != null && (p.left == pPre || p.right == pPre)) || (p.left == null && p.right == null)) &&
                    ((qPre != null && (q.left == qPre || q.right == qPre)) || (q.left == null && q.right == null))) {
                if (p.val != q.val) {
                    return false;
                }
                pPre = p;
                qPre = q;
                stackP.pop();
                stackQ.pop();
            } else {
                if (p.right != null && q.right != null) {
                    stackP.add(p.right);
                    stackQ.add(q.right);
                } else if (p.right != null || q.right != null) {
                    return false;
                }

                if (p.left != null && q.left != null) {
                    stackP.add(p.left);
                    stackQ.add(q.left);
                } else if (p.left != null || q.left != null) {
                    return false;
                }
            }
        }
        return true;
    }

}
