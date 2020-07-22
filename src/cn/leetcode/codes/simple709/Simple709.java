package cn.leetcode.codes.simple709;

import cn.leetcode.codes.PKt;

public class Simple709 {


    public static void main(String[] args) {

        String str = "Hello Word HI HI ll";

        String re = new Simple709().toLowerCase(str);
        PKt.out("re = "+re);

    }

    /*
    709. 转换成小写字母
实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。



示例 1：

输入: "Hello"
输出: "hello"
示例 2：

输入: "here"
输出: "here"
示例 3：

输入: "LOVELY"
输出: "lovely"
     */

    /*
    大写字母ASCLL码：65-90
小写字母ASCLL码：97-122
注意过滤掉除了字母以外的字符，十七正常输出
     */
    public String toLowerCase(String str) {
        if (str == null){
            return null;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c >= 'A' && c <= 'Z'){
                chars[i] += 'a' - 'A';
            }
        }
        return new String(chars);
    }


}
