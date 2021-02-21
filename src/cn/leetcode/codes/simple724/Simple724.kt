package cn.leetcode.codes.simple724

import cn.leetcode.codes.out
import com.sun.xml.internal.xsom.impl.ForeignAttributesImpl
import java.util.*

fun main() {

//    val nums = intArrayOf(1, 7, 3, 6, 5, 6)
//    val nums = intArrayOf(1,2,3)
    val nums = intArrayOf(-1,-1,-1,-1,-1,0)
    val i = pivotIndex(nums)

    out("i = $i")

}

/*
724. 寻找数组的中心索引
给你一个整数数组 nums，请编写一个能够返回数组 “中心索引” 的方法。

数组 中心索引 是数组的一个索引，其左侧所有元素相加的和等于右侧所有元素相加的和。

如果数组不存在中心索引，返回 -1 。如果数组有多个中心索引，应该返回最靠近左边的那一个。



示例 1：

输入：nums = [1, 7, 3, 6, 5, 6]
输出：3
解释：
索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
同时, 3 也是第一个符合要求的中心索引。
示例 2：

输入：nums = [1, 2, 3]
输出：-1
解释：
数组中不存在满足此条件的中心索引。


提示：

nums 的长度范围为 [0, 10000]。
任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。
 */

fun pivotIndex(nums: IntArray): Int {
    if (nums.isEmpty()) return -1

    //总和
    val sum = nums.sum()

    var leftCount = 0
    for (l in nums.indices) {
        //乘2 代表左右两边整体数据
        if ((2 * leftCount) + nums[l] == sum) {
            return l
        }
        leftCount += nums[l]
    }
    return -1
}