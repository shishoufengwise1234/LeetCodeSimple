package cn.leetcode.codes.simple50

import cn.leetcode.codes.out

fun main() {

//    val x = 2.0000
//    val n = 10
    val x = 2.0000
    val n = -2

    val re = myPow(x, n)
    out("re = $re")


}

/*
50. Pow(x, n)
实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。



示例 1：

输入：x = 2.00000, n = 10
输出：1024.00000
示例 2：

输入：x = 2.10000, n = 3
输出：9.26100
示例 3：

输入：x = 2.00000, n = -2
输出：0.25000
解释：2-2 = 1/22 = 1/4 = 0.25


提示：

-100.0 < x < 100.0
-231 <= n <= 231-1
-104 <= xn <= 104
 */

//快速幂 、 递归
fun myPow(x: Double, n: Int): Double {
    val N = n.toLong()
    return if (n >= 0) powFull(x, N) else 1.0 / powFull(x, -N)
}

private fun powFull(x: Double, n: Long): Double {
    //递归结束条件
    if (n <= 0) {
        return 1.0
    }
    //快速幂 结果
    val y = powFull(x, n / 2)
    return if (n % 2 == 0L) {
        y * y
    } else y * y * x
}






