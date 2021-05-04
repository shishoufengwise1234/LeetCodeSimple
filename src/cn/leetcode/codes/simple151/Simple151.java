package cn.leetcode.codes.simple151;

import cn.leetcode.codes.PKt;

public class Simple151 {


    public static void main(String[] args) {

        String s = "the sky is blue";
//        String s = "  hello world!  ";
//        String re = new Simple151().reverseWords(s);
        String re = new Simple151_2().reverseWords(s);

        PKt.out(re);
    }

    /*
    151. 翻转字符串里的单词
给定一个字符串，逐个翻转字符串中的每个单词。

示例 1：

输入: "the sky is blue"
输出: "blue is sky the"
示例 2：

输入: "  hello world!  "
输出: "world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
示例 3：

输入: "a good   example"
输出: "example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。


说明：

无空格字符构成一个单词。
输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。


进阶：

请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。
     */


    public String reverseWords(String s) {
        if (s == null || s.length() == 0){
            return s;
        }
        //去除空格
        StringBuilder sb  = replaceSpace(s);

//        PKt.out("去除空格之后 : = "+sb);

        //翻转字符串
        reverse(sb,0,sb.length() - 1);

//        PKt.out("翻转字符串之后 : = "+sb);

        //翻转字符串中每一个单词
        reverseWords(sb);

        return sb.toString();
    }

    public void reverseWords(StringBuilder sb){
        int left = 0,right = sb.length();
        int end = 0;
        while (left < right){
            //先找到单词边界位置
            while (end < right && sb.charAt(end) != ' ') end++;

            //翻转单词
            reverse(sb,left,end - 1);
            //更新起始值 查找下一个单词位置
            left = end + 1;
            end++;
        }
    }

    //翻转字符串
    public void reverse(StringBuilder sb,int start,int end){
        while (start < end){
            char temp = sb.charAt(start);
            sb.setCharAt(start,sb.charAt(end));
            sb.setCharAt(end,temp);
            start++;
            end--;
        }
    }

    public StringBuilder replaceSpace(String s){
        int left = 0,right = s.length() - 1;
        //先去除左边空格数量
        while (left <= right && s.charAt(left) == ' ') left++;

        //去除右边末尾空格
        while (right >= 0 && s.charAt(right) == ' ') right--;

        //去除中间多余空格
        StringBuilder sb = new StringBuilder();
        while (left <= right){
            char c = s.charAt(left);
            if (c != ' '){
                sb.append(c);
            }else if (sb.charAt(sb.length() - 1) != ' '){
                sb.append(c);
            }
            left++;
        }
        return sb;
    }







}
