package cn.leetcode.codes.simple6;

import cn.leetcode.codes.PKt;

import java.util.ArrayList;
import java.util.List;

public class Simple6 {

    /**
     * 刷题情况
     *
     * 题目地址：https://leetcode-cn.com/problems/zigzag-conversion/
     *
     * 1 刷是否通过：没有
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
     */


    public static void main(String[] args) {


        String s = "LEETCODEISHIRING";

        String re = new Simple6().convert(s,5);
        String re2 = new Simple6_2().convert(s, 3);

        PKt.out(re);
        PKt.out(re2);

    }

    /*
    6. Z 字形变换
将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);
示例 1:

输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"
示例 2:

输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:

L     D     R
E   O E   I I
E C   I H   N
T     S     G
     */

    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        //添加可拼接字符串
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            list.add(new StringBuilder());
        }

        char[] chars = s.toCharArray();
        int pos = 0;
        boolean isDown = false;
        for (char c : chars){
            list.get(pos).append(c);
            if (pos == 0 || pos == numRows - 1){
                isDown = !isDown;
            }
            pos+= isDown ? 1 : -1;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder sl : list){
            sb.append(sl);
        }
        return sb.toString();
    }

}
