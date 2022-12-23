package com.example.simplespringboottest.prac.first.leetcode;

public class TimeWindows {
    // 最长不重复子串
    // 给定一个字符串，请找出其中不含有重复字符的最长子串的长度。
    // 示例 1:
    // 输入: "abcabcbb"
    // 输出: 3
    // 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    // 示例 2:
    // 输入: "bbbbb"
    // 输出: 1
    // 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
    // 示例 3:
    // 输入: "pwwkew"
    // 输出: 3
    // 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3.
    // 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        int i = 0;
        int j = 0;
        int[] map = new int[256];
        while (j < s.length()) {
            if (map[s.charAt(j)] == 0) {
                map[s.charAt(j)] = 1;
                j++;
                max = Math.max(max, j - i);
            } else {
                map[s.charAt(i)] = 0;
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));

        String str = "aaaaaaaaabcbcbcda";
        System.out.println(getLongestSubstring(str));
    }

    // getLengthOfLongestSubstring
    public static String getLongestSubstring(String str) {
        String result = "";
        int max = 0;
        int i = 0;
        int j = 0;
        char[] chars = str.toCharArray();
        char firstChar = chars[0];
        // 0-i ,i-length
        while (i < str.length()) {
        }
        return result;
    }
}
