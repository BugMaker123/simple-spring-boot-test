package com.example.simplespringboottest.prac.first.leetcode;

public class Test {

    // timeWindow: [0, 1], [3, 5], [4, 8], [10, 12], [9, 10]
    // output: [0, 1], [3, 8], [9, 12]
    public static int[][] merge(int[][] timeWindow) {
        if (timeWindow == null || timeWindow.length == 0) {
            return timeWindow;
        }
        int[][] result = new int[timeWindow.length][2];
        int i = 0;
        int j = 0;
        while (i < timeWindow.length && j < timeWindow.length) {
            if (timeWindow[i][0] < timeWindow[j][0]) {
                result[i][0] = timeWindow[i][0];
                result[i][1] = timeWindow[i][1];
                i++;
            } else {
                result[i][0] = timeWindow[j][0];
                result[i][1] = timeWindow[j][1];
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] timeWindow = {{0, 1}, {3, 5}, {4, 8}, {10, 12}, {9, 10}};
        int[][] result = merge(timeWindow);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + " " + result[i][1]);
        }
    }

    // Two Sum II - Input array is sorted
    // Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
    // The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
    // You may assume that each input would have exactly one solution and you may not use the same element twice.
    // Input: numbers={2, 7, 11, 15}, target=9
    // Output: index1=1, index2=2
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return numbers;
        }
        int[] result = new int[2];
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                result[0] = i + 1;
                result[1] = j + 1;
                return result;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }

    // 时间窗口的最大值
    // Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
    // Input: nums = [1,2,3,1], k = 3
    // Output: true
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int[] map = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (map[i] == 0) {
                map[i] = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}
