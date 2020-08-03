package cn.leetcode.codes.simple66;

import cn.leetcode.codes.PKt;

import java.util.Arrays;

public class Simple66 {


    public static void main(String[] args) {

//        int[] digits = {1,2,9};
//        int[] digits = {0};
        int[] digits = {9};

        PKt.out(Arrays.toString(digits));
        int[] re = new Simple66().plusOne(digits);

        PKt.out("re = "+Arrays.toString(re));


    }


    /*
    66. 加一
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:

输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
示例 2:

输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。
     */

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0){
            return digits;
        }
        int p = digits.length - 1,q = 0;
        while (q <= p){
            if (digits[p] + 1 >= 10){
                digits[p] = 0;
                p--;
            }else{
                digits[p] = digits[p] + 1;
                break;
            }
        }
        return digits;
    }
}
