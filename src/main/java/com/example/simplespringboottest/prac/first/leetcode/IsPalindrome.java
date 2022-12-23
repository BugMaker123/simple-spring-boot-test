package com.example.simplespringboottest.prac.first.leetcode;

/**
 * 判断数字是否为回文数
 */
public class IsPalindrome {
    public static void main(String[] args) {
        int num = 1887881;
        boolean flag = isPalindrome(num);
        System.out.println(flag);
    }
    public static boolean isPalindrome(int x) {
        // 获取10的最高幂数
        int times = 1;
        int count =10;
        while (x%count>0 && x/count>0){
            count = count * 10;
            times++;
        }
        System.out.println(count);
        System.out.println(times);
        // 获取最高位与最低位的数字
        int c2 = 10;

        while (x/count == x%(count/c2)){
           // x/count ==
        }
        return false;
    }

    /**
     * 转成字符串,比较辣鸡
     * @param x
     * @return
     */

    public static boolean isPalindrome1(int x) {
        boolean flag = true;
        Integer num  =new Integer(x);
        char[] chars = num.toString().toCharArray();
        for (int i = 0; i <chars.length; i++) {
            if(chars[i]!=chars[chars.length-1-i]){
                flag = false;
            }
        }
        return flag;
    }
}
