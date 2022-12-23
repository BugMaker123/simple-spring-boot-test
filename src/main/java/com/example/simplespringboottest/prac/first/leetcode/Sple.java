package com.example.simplespringboottest.prac.first.leetcode;


/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class Sple {
    public static void main(String[] args) {
        String str = "bb";
        String longestResult = getLongestResult(str);
        System.out.println(longestResult);
    }

    private static String getLongestResult(String str) {
        char[] charArray = str.toCharArray();
        int left = 0;
        int right = 1;
        int start = 0;
        // 从第一个元素开始，看他前后的元素是不是相同，
        int[] num = new int[2];
        while (left >=0 && right<charArray.length-1) {
            if(charArray[left]==charArray[right]){
                if(num[1]-num[0]<right-left){
                    num[0]=left;
                    num[1] = right;
                }
                left--;
                right++;
            }else if(charArray[left]==charArray[right+1]){
                if(num[1]-num[0]<right+1-left){
                    num[0]=left;
                    num[1] = right+1;
                }else{
                    left--;
                    right = right+2;
                }

            }else{
                start++;
                left = start;
                right = start+1;
            }
        }
        return str.substring(num[0], num[1]+1);
    }
}
