package org.dongfu.controller;

import java.util.Arrays;

public class TestController {

    public static void main(String[] args) {
        int arr[] = {8, 5, 3, 2, 4};
//        maoPao(arr);
//        xuanZe(arr);
        chaRu(arr);
    }

    /**
     *　　 a、默认从第二个数据开始比较。
     *
     * 　　b、如果第二个数据比第一个小，则交换。然后在用第三个数据比较，如果比前面小，则插入（狡猾）。否则，退出循环
     *
     * 　　c、说明：默认将第一数据看成有序列表，后面无序的列表循环每一个数据，如果比前面的数据小则插入（交换）。否则退出。
     */
    // 插入排序
    private static void chaRu(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i ; j > 0 ; j--) {
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 　　a、将第一个值看成最小值
     * 　　b、然后和后续的比较找出最小值和下标
     * 　　c、交换本次遍历的起始值和最小值
     * 　　d、说明：每次遍历的时候，将前面找出的最小值，看成一个有序的列表，后面的看成无序的列表，
     *      然后每次遍历无序列表找出最小值。
     */
    //选择排序
    private static void xuanZe(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int index = i;

            for (int j = i + 1; j < arr.length; j++) {
                if(min > arr[j]){
                    min = arr[j];
                    index = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
            
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     *　　 a、冒泡排序，是通过每一次遍历获取最大/最小值
     * 　　b、将最大值/最小值放在尾部/头部
     * 　　c、然后除开最大值/最小值，剩下的数据在进行遍历获取最大/最小值
     */
    // 冒泡排序
    private static void maoPao(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }


}
