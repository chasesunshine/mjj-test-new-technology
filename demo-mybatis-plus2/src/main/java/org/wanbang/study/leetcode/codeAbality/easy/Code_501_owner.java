package org.wanbang.study.leetcode.codeAbality.easy;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 501. 二叉搜索树中的众数
 *
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 * 假定 BST 满足如下定义：
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 *
 * 示例 1：
 * 输入：root = [1,null,2,2]
 * 输出：[2]
 *
 * 示例 2：
 * 输入：root = [0]
 * 输出：[0]
 *
 */
public class Code_501_owner {
    int val;
    Code_501_owner left;
    Code_501_owner right;

    Code_501_owner(int val, Code_501_owner left, Code_501_owner right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     *           1
     *      null      2
     *             2    null
     *           1   1
     * @param args
     */
    public static void main(String[] args) {
        Code_501_owner code = new Code_501_owner(1,
                null, new Code_501_owner(2,
                new Code_501_owner(2,
                        new Code_501_owner(1,null,null),new Code_501_owner(1,null,null)),null));

        int[] mode = findMode(code);
        System.out.println(JSON.toJSONString(mode));
    }

    static List<Integer> getList = new ArrayList<>();

    /**
     * 思想： 使用递归的思想遍历二叉搜索树并且放到list中
     *
     * @param root
     * @return
     */
    public static int[] findMode(Code_501_owner root) {
        recursion(root);

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (Integer num : getList) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        // 找到最高的频率
        int maxFrequency = Collections.max(frequencyMap.values());
        // 创建一个列表来保存具有最高频率的数字
        List<Integer> mostFrequentNumbers = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                mostFrequentNumbers.add(entry.getKey());
            }
        }
        int[] intArray = mostFrequentNumbers.stream().mapToInt(Integer::intValue).toArray();
        return intArray;
    }

    /**
     * 个人做出来的
     * 第一次做出来递归的思路
     *
     * 个人怎么做出来的想法：
     *
     *              a
     *       null         b
     *                c     null
     *              d   e
     *
     * 比如以上这个 二叉查找树
     * 先判断 a 是否是null，是的话不作处理
     *                   不是的话把 a 中的数据取出来
     *                      再判断 a 和 a 左分支的数据 是否是null ， 是的话不做处理
     *                      在判断 a 和 a 右分支的数据 是否是null ， 是的话不做处理
     *                          不是的话把 a 右分支的 赋值给它本身
     *               这样递归就产生了
     *
     * @param root
     */
    private static void recursion(Code_501_owner root) {
        if(root != null){
            int val1 = root.val;
            getList.add(val1);
        }
        if(root != null && root.left != null){
            recursion(root.left);
        }
        if(root != null && root.right != null){
            recursion(root.right);
        }
    }
}
