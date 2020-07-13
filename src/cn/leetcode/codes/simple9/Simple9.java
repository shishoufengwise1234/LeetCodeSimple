package cn.leetcode.codes.simple9;

import cn.leetcode.codes.PKt;

public class Simple9 {


    public static void main(String[] args) {

//        int x = -121; //false
//        int x = 121; //true
//        int x = 11; //true
//        int x = 10; //true
        int x = 0; //true
        boolean isPalindrome = new Simple9().isPalindrome(x);

        PKt.out(isPalindrome);

    }

    /*
    9. 回文数
判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:

输入: 121
输出: true
示例 2:

输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3:

输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。
进阶:

你能不将整数转为字符串来解决这个问题吗？
     */


    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        String sStr = String.valueOf(x);
        char[] chars = sStr.toCharArray();
        int low = 0,hgt = chars.length - 1;
        while (low <= hgt){
            if (chars[low] != chars[hgt]){
                return false;
            }
            low++;
            hgt--;
        }
        return true;
    }





}
