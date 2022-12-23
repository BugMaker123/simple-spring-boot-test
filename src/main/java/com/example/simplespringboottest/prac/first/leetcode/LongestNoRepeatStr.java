package com.example.simplespringboottest.prac.first.leetcode;


import java.util.HashMap;

public class LongestNoRepeatStr {
    public static void main(String[] args) {
        String str = "dfdv";
        System.out.println(lengthOfLongestSubstring(str));
    }

    private static Integer lengthOfLongestSubstring(String str) {
        HashMap<Character,Integer> map = new HashMap<>();

        int length = str.length();
        int start = 0;
        int end = 0;
        // 设定窗口宽度为0
        int winWidth = 0;
        // 从头开始遍历
        char[]chars = str.toCharArray();
        while(start<=end && end<length){
            // 如果
            // 如果尾部的数据在窗口中不存在则窗口宽度+1
            if(!map.containsKey(chars[end])){
                map.put(chars[end],end);
                end++;
                winWidth = Math.max(winWidth,end-start);
            }else{
                // 否则窗口宽度不变，
                start = map.get(chars[end]);
                start++; // 窗口左边界移动到重复元素的位置
                end = start;
                map.clear();
            }
        }
        return winWidth;
    }
}
