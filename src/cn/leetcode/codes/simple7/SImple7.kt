package cn.leetcode.codes.simple7

import cn.leetcode.codes.out

/*

7. 整数反转
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

输入: 123
输出: 321
 示例 2:

输入: -123
输出: -321
示例 3:

输入: 120
输出: 21
注意:

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。


 */

fun main(){

    out(reverse(123))


}


fun reverse(x: Int): Int {
    var ans = 0

    var y = x
    while (y != 0){
        val pop = x % 10
        //溢出检查
        if (ans > Int.MAX_VALUE / 10 || (ans == Int.MAX_VALUE / 10 && pop > 7)){
            return 0
        }
        if (ans < Int.MIN_VALUE / 10 || (ans == Int.MIN_VALUE / 10 && pop < -8)){
            return 0
        }
        ans = ans * 10 + pop
        y /= 10
    }
    return ans
}