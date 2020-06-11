package cn.leetcode.codes.simple3;

import cn.leetcode.codes.PKt;

public class Simple3 {

     /**
       *
       * 刷题情况
       *
       * 题目地址：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
       *
       * 1 刷是否通过：
       *
       *
       * 2 刷是否完成：
       *
       *
       * 3 刷是否完成：
       *
       *
       * 4 刷是否完成：
       *
       *
       * 5 刷是否完成：
       *
       *
       *
       */

    public static void main(String[] args){

        String s = "abcabcbb";
        int re = new Simple3().lengthOfLongestSubstring(s);

        PKt.out(" re = "+re);

    }
    /*

    3. 无重复字符的最长子串
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int q = 1;
        int p = 0;
        int count = 0;
        while (p != len){


        }
        return count;
    }


}
