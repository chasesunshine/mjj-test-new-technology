package org.wanbang.study.arrayListConcurrentModificationException;

import java.util.ArrayList;

// https://blog.csdn.net/qq_35056292/article/details/79751233
public class Test {
    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i=0; i<10; i++){
            arr.add(i);
        }

        for(Integer i: arr){
            if(i == 5){
                arr.remove(i);
            }
            else{
                System.out.println(i);
            }
        }
    }
}
