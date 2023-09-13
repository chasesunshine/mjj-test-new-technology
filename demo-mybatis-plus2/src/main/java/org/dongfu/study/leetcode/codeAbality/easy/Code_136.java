package org.dongfu.study.leetcode.codeAbality.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 *
 * 示例 2:
 * 输入: [4,1,2,1,2]
 */

public class Code_136 {
    /**
     * 思路：
     *拿到这道题，若不考虑复杂度，相信大家都能做出来，但是最终的复杂度基本都是 nnn。
     *
     * 这道题的真实目的其实是在考察我们能否用线性的时间和常量的空间来完成。
     *
     * 如何实现呢？答案呼之欲出，我们应该使用位运算其中的异或运算。
     *
     * 首先针对异或运算，这里做一个知识点的总结：
     *
     * 任何数和自己做异或运算，结果为 000，即 a⊕a=0a⊕a=0a⊕a=0 。
     * 任何数和 000 做异或运算，结果还是自己，即 a⊕0=⊕a⊕0=⊕a⊕0=⊕。
     * 异或运算中，满足交换律和结合律，也就是 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=ba⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=ba⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。
     *
     */
    public static void main(String[] args) {
        int[] nums = new int[]{4,1,2,1,2};
        int i = singleNumber(nums);
        System.out.println(i);
    }

    public static int singleNumber(int[] nums) {
        Set<Integer> integerSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(integerSet.contains(num)){
                integerSet.remove(num);
            }else {
                integerSet.add(num);
            }
        }
        return integerSet.iterator().next();
    }

    /**
     * 这个思路好
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

}
