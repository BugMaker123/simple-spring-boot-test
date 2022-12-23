package com.example.simplespringboottest.prac.first.leetcode;

/**
 * 第十题
 */
public class TwoNumSum {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6,9};
        int target = 12;
        int[] twoSum = twoSum(nums, target);
        for (int i = 0; i < twoSum.length; i++) {
            System.out.println(twoSum[i]);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length ; j++) {
                if (nums[i]+nums[j]==target){
                    nums= new int[]{i, j};
                    break;
                }
            }
        }
        return nums;
    }
}
