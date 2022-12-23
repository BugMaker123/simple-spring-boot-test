package com.example.simplespringboottest.prac.first.leetcode.swardOffer;

import java.util.*;

/**
 * 给定两个字符串s和p，找到s中所有 p 的变位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 变位词 指字母相同，但排列不同的字符串。
 * <p>
 * <p>
 * <p>
 * 示例1：
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的变位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的变位词。
 * 示例 2：
 * <p>
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的变位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的变位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的变位词。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/VabMRr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ChangePlaceWord {
    public static void main(String[] args) {
        String s1 = "cbaebabacd";
        String s2 = "abc";
        findAnagrams(s1, s2);
        checkInclusion(s2,s1);
        char a = 'a';
        char A = 'A';
        System.out.println((int) a);
        System.out.println((int) A);

    }

    public static boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; ++i) {
            cnt1[s1.charAt(i) - 'a']++;
           cnt2[s2.charAt(i) - 'a'] ++;
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
        for (int i = n; i < m; ++i) {
            ++cnt2[s2.charAt(i) - 'a'];
            --cnt2[s2.charAt(i - n) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int pLen = p.length();
        int sLen = s.length();
        if (pLen>sLen) return new ArrayList<Integer>();
        List<Integer> list = new LinkedList<>();

        // 避免有相同字符,选择HashMap存储数据,key作为字符值,value计数
        HashMap<Character, Integer> pMap = operationStr(p);
        int start = 0;
        while(start + pLen<=s.length()){
            String substring = s.substring(start, start + pLen);
            HashMap<Character, Integer> sMap = operationStr(substring);
            boolean matches = matches(sMap, pMap);
            if (matches){
                // 如果匹配，要看当前start在集合中是否存在
                list.add(start);
                //list.add(start+pLen);
            }
            start++;
        }
        return list;
    }


    static HashMap<Character,Integer> operationStr(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i <str.length(); i++) {
            if (map.containsKey(str.charAt(i))){
                map.put(str.charAt(i), map.get(str.charAt(i))+1);
            }else{
                map.put(str.charAt(i),1);
            }
        }
        return map;
    }

    static boolean matches(HashMap<Character, Integer>map1 ,HashMap<Character, Integer>map2){
        for (Character key: map1.keySet()) {
            if (map1.get(key).equals(map2.get(key))){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }


}
