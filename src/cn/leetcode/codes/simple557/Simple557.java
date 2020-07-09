package cn.leetcode.codes.simple557;

import cn.leetcode.codes.PKt;

public class Simple557 {

    /**
     * 刷题情况
     * <p>
     * 题目地址：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
     * <p>
     * 1 刷是否通过： 通过  自己写的算法 reverseWords2 个人算法 比 官方解题方案一 时间要短、但是代码比较复杂
     * <p>
     * <p>
     * 2 刷是否完成：
     * <p>
     * <p>
     * 3 刷是否完成：
     * <p>
     * <p>
     * 4 刷是否完成：
     * <p>
     * <p>
     * 5 刷是否完成：
     * <p>
     * 最优解析：
     */
    public static void main(String[] args) {

        String s = "Let's take LeetCode contest";

        String s1 = new Simple557().reverseWords(s);
//        String s1 = new Simple557().reverseWords2(s);

        PKt.out(s1);

    }

    /*
    557. 反转字符串中的单词 III
给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

示例 1:

输入: "Let's take LeetCode contest"
输出: "s'teL ekat edoCteeL tsetnoc"
注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
     */

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String[] splits = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : splits){
            sb.append(new StringBuilder(str).reverse().toString()).append(" ");
        }
        return sb.toString().trim();
    }

    //个人算法
    public String reverseWords2(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder reSb = new StringBuilder();
        String[] strings = s.split(" ");
        int len = strings.length;
        for (int i = 0; i < len; i++) {
            String sub = strings[i];
            char[] subs = sub.toCharArray();
            int p = 0, q = subs.length - 1;
            while (p <= q) {
                char c = subs[p];
                subs[p] = subs[q];
                subs[q] = c;

                p++;
                q--;
            }
            reSb.append(subs);
            if (i != len - 1) {
                reSb.append(" ");
            }
        }
        return reSb.toString();
    }


}
