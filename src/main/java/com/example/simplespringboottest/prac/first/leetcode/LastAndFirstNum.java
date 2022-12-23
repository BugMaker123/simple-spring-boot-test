package com.example.simplespringboottest.prac.first.leetcode;

public class LastAndFirstNum {
    public static void main(String[] args) {
        int num[] = {5,7,7,8,8,10};

        int target = 8;
        int[] ints = searchRange(num, target);
    }

    public static int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return new int[]{-1, -1};
        }
        int[] res = new int[2];
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        while (left <= right) {
            if(nums[left] == nums[right] && nums[left]!=target){
                return new int[]{-1, -1};
            }

            if (target > nums[mid]) {
                left = mid + 1;
                mid = (left + right) / 2;
            } else if (target < nums[mid]) {
                right = mid - 1;
                mid = (left + right) / 2;
            } else if (target == nums[mid]) {
                int min = mid, max = mid;
                while (min >= 0 && nums[min] == target) {
                    min--;
                }
                while (max < nums.length && nums[max] == target) {
                    max++;
                }
                res[0] = min + 1;
                res[1] = max - 1;
                break;
            } else {
                return new int[]{-1, -1};
            }
        }
        return res;
    }
}
