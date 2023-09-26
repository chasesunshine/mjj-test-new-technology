package org.wanbang.util;

import java.util.Arrays;

public class TestSon extends Test{

    public TestSon(String a) {
        super(a);
    }

    public static void main(String[] args) {
        int[] arr = {4,9,5,1,2,6};
        bubbleSortOpt(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSortOpt(int[] arr) {

        if(arr == null) {
            return;
        }
        if(arr.length < 2) {
            return;
        }
        int temp = 0;
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
