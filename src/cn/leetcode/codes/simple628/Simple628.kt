package cn.leetcode.codes.simple628

import cn.leetcode.codes.out
import java.util.*
import kotlin.math.max

fun main() {

//    val nums = intArrayOf(1,2,3)
//    val nums = intArrayOf(1,2,3,4)
//    val nums = intArrayOf(-1,-2,-3)
    val nums = intArrayOf(-100,-98,-1,2,3,4)

    out(maximumProduct(nums))


}

/*
628. 三个数的最大乘积
给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。

示例 1:

输入: [1,2,3]
输出: 6
示例 2:

输入: [1,2,3,4]
输出: 24
注意:

给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 */

fun maximumProduct(nums: IntArray): Int {
    if (nums.size < 3){
        return 0
    }
    Arrays.sort(nums)
    val size = nums.size
    return max(nums[0] * nums[1] * nums[size - 1],nums[size - 3] * nums[size - 2] * nums[size - 1])
}