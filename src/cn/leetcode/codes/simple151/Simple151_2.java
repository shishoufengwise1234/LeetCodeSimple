package cn.leetcode.codes.simple151;

import java.util.Stack;

public class Simple151_2 {


    //
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;

        Stack<String> stack = new Stack<>();
        StringBuilder word = new StringBuilder();

        //使用栈不断将单词入栈
        for (int i = 0; i < len; i++) {
            if (chars[i] != ' '){
                word.append(chars[i]);
                if (i == len - 1 || chars[i + 1] == ' '){   //最后一个元素 或 找到一个完整单词
                    stack.push(word.toString());
                    //复用StringBuilder
                    word.delete(0, word.length());
                }
            }
        }
        //从栈中将单词弹出来
        StringBuilder ans = new StringBuilder();

        while (!stack.isEmpty()){
            ans.append(stack.pop());
            //如果栈还没有空 则追加空格
            if (!stack.isEmpty()){
                ans.append(' ');
            }
        }

        return ans.toString();
    }

    //执行错误
//    public String reverseWords(String s) {
//        if (s == null || s.length() == 0) {
//            return s;
//        }
//        StringBuilder ans = new StringBuilder();
//
//        StringBuilder sw = new StringBuilder(s);
//
//        int len = sw.length();
//
//        for (int first = len - 1 - 1, low = len - 1; first >= 0 && low >= 0; first--) {
//            if (sw.charAt(low) == ' ') {
//                low--;
//            } else if (first == 0 && sw.charAt(0) != ' ') {   //处理第一个元素情况
//                ans.append(sw.subSequence(first, low));
//                ans.append(' ');
//                low = first;
//            } else if (first >= 1 && sw.charAt(first - 1) == ' ') {
//                ans.append(sw.subSequence(first, low));
//                ans.append(' ');
//                low = first;
//            }
//        }
//        return ans.toString();
//    }

}
