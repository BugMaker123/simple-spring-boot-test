package com.example.simplespringboottest.prac.practice.algorithm;

/**
 * @ ClassName: Bupple
 * @Author: legen
 * @Date: 2020/12/11
 */
public class BubbleSort {
   static int []arr={3,55,58,2,12,569};

    public static void main(String[] args) {
        int temp=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length-1; j++) {
                if (arr[i]>arr[j]){
                    temp=arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
