package cn.leetcode.codes.simple14;

import cn.leetcode.codes.PKt;

public class Simple14 {


    public static void main(String[] args) {
        String[] strings = {"flower","flow","flight"};
//        String[] strings = {"dog","racecar","car"};
//        String[] strings = {"aca","cba"};
        String re = new Simple14().longestCommonPrefix(strings);

        PKt.out(re);


    }

    /*
    14. 最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。
     */

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <= 0){
            return "";
        }
        //将第一个字符串为 公共前缀字符串
        String con = strs[0];
        //遍历字符串数组 依次和后面的字符串进行对比
        for (String str : strs) {
            //如果后面的字符串 不相同则 直接跳转出来
            int j = 0;
            for (; j < con.length() && j < str.length(); j++) {
                if (con.charAt(j) != str.charAt(j)) {
                    break;
                }
            }
            con = con.substring(0, j);
            if (con.equals("")) {
                return "";
            }
        }
        return con;
    }

}
