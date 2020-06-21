package cn.leetcode.codes.simple344;

import cn.leetcode.codes.PKt;

import java.awt.font.NumericShaper;
import java.util.Arrays;

public class Simple344 {

    public static void main(String[] args) {
//        char[] chars = new char[]{'h', 'e', 'l', 'l', 'o'};
        char[] chars = new char[]{'H','a','n','n','a','h'};
        PKt.out(Arrays.toString(chars));
        PKt.out("-------------");

        new Simple344().reverseString(chars);

        PKt.out(Arrays.toString(chars));
    }

    /*

    344. 反转字符串
编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。

不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。

你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。



示例 1：

输入：["h","e","l","l","o"]
输出：["o","l","l","e","h"]
示例 2：

输入：["H","a","n","n","a","h"]
输出：["h","a","n","n","a","H"]

     */

    public void reverseString(char[] s) {
        if (s == null || s.length <= 0) {
            return;
        }
        int l = s.length - 1, p = 0;
        while (p < l) {
            char temp = s[p];
            s[p] = s[l];
            s[l] = temp;

            l--;
            p++;
        }
    }


}
