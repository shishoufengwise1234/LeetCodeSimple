package cn.leetcode.codes.simple169

import java.util.*

class Simple169_2 {

    fun majorityElement(nums: IntArray): Int {
        //排序
        Arrays.sort(nums)

        return nums[nums.size / 2]
    }
}