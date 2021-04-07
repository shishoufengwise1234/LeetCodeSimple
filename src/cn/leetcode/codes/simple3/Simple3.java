package cn.leetcode.codes.simple3;

import cn.leetcode.codes.PKt;

import java.util.HashMap;
import java.util.Map;

public class Simple3 {

    /**
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
     * 最优解析：
     *
     *
     * 面试是否遇到过？
     *
     *
     * 企业：
     *
     * 作业帮
     *
     *
     */


    public static void main(String[] args){

        String s = "abcabcbb";
        int re = new Simple3().lengthOfLongestSubstring(s);
        int re3 = Simple3_3Kt.lengthOfLongestSubstring(s);
        int re4 = new Simple3_4().lengthOfLongestSubstring(s);
        int re5 = new Simple3_5().lengthOfLongestSubstring(s);

        PKt.out(" re = "+re);
        PKt.out(" re3 = "+re3);
        PKt.out(" re4 = "+re4);
        PKt.out(" re5 = "+re5);

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
        if (s == null || s.length() <= 0){
            return 0;
        }
        Map<Character,Integer> hashMap = new HashMap<>();
        char[] chars = s.toCharArray();
        int max = 0;
        int left = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (hashMap.containsKey(c)){
                left = Math.max(left,hashMap.get(c) + 1);
            }
            hashMap.put(c,i);
            max = Math.max(max,i - left+1);
        }
        return max;
    }


}
