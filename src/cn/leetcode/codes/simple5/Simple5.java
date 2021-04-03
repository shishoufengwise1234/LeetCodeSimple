package cn.leetcode.codes.simple5;

import cn.leetcode.codes.PKt;

public class Simple5 {


    public static void main(String[] args) {

        String s = "babad";

        String re = new Simple5_3().longestPalindrome(s);
        PKt.out(" re = "+re);

    }


    /*
    5. 最长回文子串
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"
     */


    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0){
            return null;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {

        }

        return "";
    }
}
