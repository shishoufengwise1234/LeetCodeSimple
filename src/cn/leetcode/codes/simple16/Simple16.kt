package cn.leetcode.codes.simple16

import cn.leetcode.codes.out
import java.util.*
import kotlin.math.abs

fun main() {

    val nums = intArrayOf(-1,2,1,-4)

    val re = threeSumClosest(nums,2)

    out("re = $re")


}

/*
16. 最接近的三数之和
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。



示例：

输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。


提示：

3 <= nums.length <= 10^3
-10^3 <= nums[i] <= 10^3
-10^4 <= target <= 10^4
 */

fun threeSumClosest(nums: IntArray, target: Int): Int {
    //排序
    Arrays.sort(nums)

    //预定义一个值
    var ans = nums[0] + nums[1] + nums[2]

    for (i in nums.indices){
        //内部进行双指针循环
        var l = i+1
        var r = nums.size - 1
        while (l < r){
            val sum = nums[i] + nums[l] + nums[r]
            when {
                abs(target - sum) < abs(target - ans) -> {
                    ans = sum
                }
                sum < target -> {
                    l++
                }
                sum > target -> {
                    r--
                }
                //距离相等的情况下 0 直接返回数据
                else -> return ans
            }
        }
    }
    return ans
}