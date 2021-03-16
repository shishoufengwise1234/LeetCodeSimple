package cn.leetcode.codes.simple69

import cn.leetcode.codes.out

fun main() {

//    out("4 = ${mySqrt(4)}")
//    out("8 = ${mySqrt(8)}")
    out("2147395599 = ${mySqrt(2147395599)}")


}

//二分法
fun mySqrt(x: Int): Int {
    if (x <= 0) return 0

    var l = 0
    var r = x
    var ans = 0
    while (l <= r) {
        val mid = l + (r - l) / 2

        if ((mid * mid.toLong()) <= x) {
            ans = mid
            l = mid + 1
        } else {
            r = mid - 1
        }
    }
    return ans
}