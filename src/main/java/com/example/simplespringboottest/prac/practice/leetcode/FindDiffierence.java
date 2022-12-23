package com.example.simplespringboottest.prac.practice.leetcode;

/**
 * @ ClassName: FindDiffierence
 * @Author: legen
 * @Date: 2020/12/18
 */
/*给定两个字符串 s 和 t，它们只包含小写字母。

字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。

请找出在 t 中被添加的字母。


示例 1：

输入：s = "abcd", t = "abcde"
输出："e"
解释：'e' 是那个被添加的字母。
示例 2：

输入：s = "", t = "y"
输出："y"
示例 3：

输入：s = "a", t = "aa"
输出："a"
示例 4：

输入：s = "ae", t = "aea"
输出："a"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-the-difference
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class FindDiffierence {
    public static void main(String[] args) {
        String s = "ae";
        char[] chars = s.toCharArray();
        String t = "aea";
        char[] charst = t.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < charst.length;j++) {
                if (chars[i]==charst[j]){
                    continue;
                }
                System.out.println(charst[j]);
                break;
            }
        }
        getResult(s,t);
    }

    static void getResult(String source ,String target){
        // 1.获取source的hashCode的和
        char[] sourceCh = source.toCharArray();
        int hashCodeSum1 = 0;
        for (int i = 0; i < sourceCh.length; i++) {
            hashCodeSum1 =hashCodeSum1+ sourceCh[i];
        }
        // 2.获取target的hashCode的和
        char[] hashCodeTarget = target.toCharArray();
        int hashCodeSum2 = 0;
        for (int i = 0; i < hashCodeTarget.length; i++) {
            hashCodeSum2 =hashCodeSum2+ hashCodeTarget[i];
        }
        System.out.println((char)(hashCodeSum2-hashCodeSum1));
    }


}
