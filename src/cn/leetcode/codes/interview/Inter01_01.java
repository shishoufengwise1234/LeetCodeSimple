package cn.leetcode.codes.interview;

import cn.leetcode.codes.PKt;

import java.util.HashMap;
import java.util.HashSet;

public class Inter01_01 {


    public static void main(String[] args) {

//        String s = "leetcode";
        String s = "abc";

        boolean isUnique = new Inter01_01().isUnique(s);
        PKt.out(isUnique);
    }

    /*

面试题 01.01. 判定字符是否唯一
实现一个算法，确定一个字符串 s 的所有字符是否全都不同。

示例 1：

输入: s = "leetcode"
输出: false
示例 2：

输入: s = "abc"
输出: true
限制：

0 <= len(s) <= 100
如果你不使用额外的数据结构，会很加分。


     */


    // 借助hashset 容器实现
    public boolean isUnique(String astr) {
        if (astr == null || astr.length() == 0){
            return true;
        }
        char[] chars = astr.toCharArray();
        int length = chars.length;
        HashSet<Character> set = new HashSet<>(length);

        for (char c : chars) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }
}
