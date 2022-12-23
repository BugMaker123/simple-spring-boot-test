package com.example.simplespringboottest.prac.first.leetcode;

import java.util.HashMap;

public class TimeWindowTest {
    public static void main(String[] args) {
        String str = "abcabcdabc";
        Integer res = getLongestNoRepeatChild(str);
        System.out.println(res);
    }

    private static Integer getLongestNoRepeatChild(String str) {
        // 设定目标长度
        int maxWindowsWidth = 0;
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        // MAP中存储字符与其索引位置
        char[] charArray = str.toCharArray();
        while (left <=right && right < str.length()) {
            if(!map.containsKey(charArray[right])){
                // 如果不包含该字符串，就放到map中
                map.put(charArray[right],right);
                // 调整右侧位置
                right++;
                // 计算窗口大小
                maxWindowsWidth = maxWindowsWidth>(right-left)? maxWindowsWidth:(right-left);
            }else{
                // 如果已经有了该元素，窗口大小不调整
                // 1查找map中重复元素的位置
                left = map.get(charArray[right]);
                // 从重复元素的下一个位置开始重新添加元素
                left++;
                right =left;
                map.clear();
            }
        }
        return maxWindowsWidth;
    }

}
