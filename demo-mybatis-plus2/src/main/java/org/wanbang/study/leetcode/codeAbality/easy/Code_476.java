package org.wanbang.study.leetcode.codeAbality.easy;

public class Code_476 {
    public static void main(String[] args) {
        int num = 5;
        int complement = findComplement(num);
        System.out.println(complement);
    }

    /**
     * 个人没做出来
     * 思想是异或的思想
     *
     * @param num
     * @return
     */
    public static int findComplement(int num) {
        int temp = num, c = 0;
        while(temp > 0){
            temp >>= 1;
            c =  (c << 1) + 1;
        }
        return num ^ c;
    }
}
