package org.wanbang.study.leetcode.codeAbality;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class test {
    public static void main(String args[]){
        Scanner input = new Scanner( System.in );
        System.out.print("Enter a binary number: ");
        String binaryString =input.nextLine();

        log.info("意思就是：输出2进制数1010在十进制下的数 , " +
                "更直白地说： parseInt(String s,int radix)就是求“int radix”进制数“String s”的十进制数是多少。");
        System.out.println("Output: "+Integer.parseInt(binaryString,8));
    }
}
