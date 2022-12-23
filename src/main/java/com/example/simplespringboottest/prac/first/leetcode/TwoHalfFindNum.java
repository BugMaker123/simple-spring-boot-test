package com.example.simplespringboottest.prac.first.leetcode;

/**
 * 二分查找
 */
public class TwoHalfFindNum {
    public static void main(String[] args) {
        int []arr = {1,2,5,9,14,29,30,35};
        int target =35;
        int index = findTarget(arr, target);
        System.out.println(index);
    }

    /**
     *
     * @param arr
     * @param target
     * @return
     */
    private static int findTarget(int[]arr, int target) {
        int mid;
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            if (left==right && target!=arr[left] ){
                throw new RuntimeException("NO THIS NUM");
            }
            // 中间值
            mid = left+(right-left)/2;
            // 如果当前中间值比目标值大，右指针左移
            if(arr[mid]>target){
                right = mid-1;
            }else if (arr[mid]<target){// 如果当前中间值比目标值小，左指针右移
                left = mid+1;
            }else{
                return mid;
            }
        }
        return 0;
    }
    /**
     * 二分查找
     */
    public void findNum(int []arr,int num){

    }
}
