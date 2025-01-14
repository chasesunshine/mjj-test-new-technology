package org.wanbang.study.leetcode.codeAbality.easy;

/**
 * 404. 左叶子之和
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 *
 * 示例 1：
 *      输入: root = [3,9,20,null,null,15,7]
 *      输出: 24
 *      解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * 示例 2:
 *      输入: root = [1]
 *      输出: 0
 *
 */
public class Code_404 {
    int val;
    Code_404 left;
    Code_404 right;

    Code_404() {}

    Code_404(int val) {
        this.val = val;
    }

    Code_404(int val, Code_404 left, Code_404 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main (String[]args){
        Code_404 code = new Code_404(3,
                new Code_404(9,null,null),
                new Code_404(20,new Code_404(15,null,null),new Code_404(7,null,null)));
        int i = sumOfLeftLeaves(code);
        System.out.println(i);
    }

    static int res=0;//全局变量存放累加的左叶子节点之和
    // 用递归的思想
    public static int sumOfLeftLeaves(Code_404 root) {
        if(root==null) return 0;//终止条件
        //满足下列条件，该节点的左子节点即是左叶子节点
        if(root.left!=null && root.left.left==null && root.left.right==null){
            res = res + root.left.val;//判断左叶子节点只能从当前节点判断，如果是左叶子节点，加入结果集
        }

        sumOfLeftLeaves(root.left);//遍历左树
        sumOfLeftLeaves(root.right);//遍历右树

        return res;//遍历完所有节点，返回左叶子之和
    }

}
