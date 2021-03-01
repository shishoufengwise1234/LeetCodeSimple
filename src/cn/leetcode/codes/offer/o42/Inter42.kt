package cn.leetcode.codes.offer.o42

import cn.leetcode.codes.out
import kotlin.math.max

fun main() {

    val nums = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
//    val nums = intArrayOf(1)
    out(maxSubArray(nums))

}

/*
剑指 Offer 42. 连续子数组的最大和
输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。

要求时间复杂度为O(n)。



示例1:

输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。


提示：

1 <= arr.length <= 10^5
-100 <= arr[i] <= 100
注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/
 */


//正数增益
// https://leetcode-cn.com/problems/maximum-subarray/solution/hua-jie-suan-fa-53-zui-da-zi-xu-he-by-guanpengchn/
fun maxSubArray(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    var sum = 0
    var ans = nums[0]

    nums.forEach { n ->
        //之前sum大于零 对整体总和有帮助
        if (sum > 0) {
            sum += n
        } else { //向后进 以当前值为开始 重新开始计算总和
            sum = n
        }
        ans = max(ans, sum)
    }
    return ans
}

