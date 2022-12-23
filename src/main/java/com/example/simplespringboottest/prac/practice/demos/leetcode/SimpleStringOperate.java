package com.example.simplespringboottest.prac.practice.demos.leetcode;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * 示例 2：
 *
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 *  
 *
 * 限制：
 *
 * 1 <= k < s.length <= 10000
 * @ ClassName: SimpleStringEdit
 * @Author: legen
 * @Date: 2021/6/1
 */
public class SimpleStringOperate{
    public static void main(String[] args) {
        String word="abcdefg";
        int n = 0;
        String s = reverseLeftWords(word, 1);
        System.out.println(s);
    }
    public static String reverseLeftWords(String s, int n) {
        String str = s.substring(n);
        String endStr = s.substring(0, n);
        StringBuffer sb = new StringBuffer(str);
        return sb.append(endStr).toString();
    }

}
