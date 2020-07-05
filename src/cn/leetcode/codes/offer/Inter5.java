package cn.leetcode.codes.offer;

import cn.leetcode.codes.PKt;

public class Inter5 {

     /**
       *
       * 刷题情况
       *
       * 题目地址： https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
       *
       * 1 刷是否通过：未完成
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


    public static void main(String[] args) {

        String s = "We are happy.";

        String re = new Inter5().replaceSpace(s);

        PKt.out("re = "+re);

    }

    /*


    面试题05. 替换空格
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。



示例 1：

输入：s = "We are happy."
输出："We%20are%20happy."


限制：

0 <= s 的长度 <= 10000


     */


    public String replaceSpace(String s) {

//        return s.replaceAll(" ","%20");

        //由于添加的替换的是三个字符 所以申请 是原来 3 倍 的数组长度进行存储字符
        char[] array = new char[s.length() * 3];

        //使用快指针记录真实插入字符的长度
        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' '){
                array[pos++] = '%';
                array[pos++] = '2';
                array[pos++] = '0';
            }else{
                // 往数组中 按照位置添加每一个 字符
                array[pos++] = c;
            }
        }
        // 重新构建一个字符串
        String re = new String(array,0,pos);

        return re;

    }
}
