package org.dongfu.study.leetcode.codeAbality.easy;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点。
 *
 * 示例 1：
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 *
 * 示例 2：
 * 输入：root = [1]
 * 输出：["1"]
 */

public class Code_257 {
    /**
     * 思路：
     *
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
        List<String> strings = binaryTreePaths(treeNode);

        System.out.println(JSON.toJSONString(strings));
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        if(root==null) return ret;
        solve(root, "", ret);
        return ret;
    }

    public static void solve(TreeNode root, String cur, List<String> ret){
        if(root==null) return;
        cur += root.val;
        if(root.left==null&&root.right==null){
            ret.add(cur);
        }else{
            solve(root.left, cur+"->", ret);
            solve(root.right, cur+"->", ret);
        }
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