package org.wanbang.study.leetcode.codeAbality.easy;

import com.alibaba.schedulerx.shade.scala.Int;
import org.assertj.core.util.Arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * 496. 下一个更大元素 I
 *
 * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 *
 * 示例 1：
 * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出：[-1,3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * - 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
 * - 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 *
 * 示例 2：
 * 输入：nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出：[3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 2 ，用加粗斜体标识，nums2 = [1,2,3,4]。下一个更大元素是 3 。
 * - 4 ，用加粗斜体标识，nums2 = [1,2,3,4]。不存在下一个更大元素，所以答案是 -1 。
 */
public class Code_496 {
    public static void main(String[] args) {
        int[] num1 = {4,1,2};
        int[] num2 = {1,3,4,2};
        int[] ints = nextGreaterElement(num1, num2);
        System.out.println(Arrays.asList(ints));
    }

    /**
     * 做出来了，但是编译器不支持
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        List<Object> objects = Arrays.asList(nums2);
        for (int i = 0; i < nums1.length; i++) {
            int value = nums1[i];
            int indexOf = objects.indexOf(value);
            if(indexOf >= objects.size()-1){
                nums1[i] = -1;
            }else {
                Integer o = (Integer) objects.get(indexOf + 1);
                if(o > value){
                    nums1[i] = Integer.valueOf(o.toString());
                }else {
                    nums1[i] = -1;
                }
            }
        }
        return nums1;
    }


    /**
     * 用栈的思想
     *
     * 两个for循环太复杂
     * 一个for循环就够了，太影响空间和时间复杂度
     *
     * 思想不错
     *
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> hasMap = new HashMap<>();

        int[] result = new int[nums1.length];

        for(int num : nums2) {
            while(!stack.isEmpty() && stack.peek()<num){
                hasMap.put(stack.pop(), num);
            }
            stack.push(num);
        }

        for(int i = 0; i < nums1.length; i++) result[i] = hasMap.getOrDefault(nums1[i], -1);

        return result;
    }

}
