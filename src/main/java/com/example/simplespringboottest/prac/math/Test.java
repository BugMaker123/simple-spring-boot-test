package com.example.simplespringboottest.prac.math;

public class Test {
    public static void main(String[] args) {
        int target=-1;
        int[] nums={-1,0,3,5,6,9,11,12};
        int search = search(nums, target);
        System.out.println(search);
    }

    public static int search(int[] nums, int target) {
        int left=0;
        int right  = nums.length-1;
        while(left<=right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {
                left = mid + 1;
            }
            if (target< nums[mid]) {
                right = mid - 1;
            }
        }
        return -1;
    }

    static  int firstBadVersion(int n) {

        return 0;
    }
}
