package com.example.simplespringboottest.prac.practice.leetcode;

import java.util.HashMap;

public class OnceNum {
    public static void main(String[] args) {
        int [] nums = {1,2,1,3,2,5};
        getOnceNumArray(nums);
    }
    static int[] getOnceNumArray(int[]arr){
        int count = 0;
        int []newArr = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])){
                map.put(arr[i],2);
            }else {
                map.put(arr[i],count);
                count++;
            }
        }
        return newArr;
    }
}
