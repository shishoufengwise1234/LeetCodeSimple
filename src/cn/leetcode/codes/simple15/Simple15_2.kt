package cn.leetcode.codes.simple15

import cn.leetcode.codes.out
import java.util.*

class Simple15_2 {

    /*
    15. 三数之和
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。



示例 1：

输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
示例 2：

输入：nums = []
输出：[]
示例 3：

输入：nums = [0]
输出：[]


提示：

0 <= nums.length <= 3000
-105 <= nums[i] <= 105
     */

    fun threeSum(nums: IntArray): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        //数组长度不足3条 不满足要求
        if (nums.size < 3) {
            return ans
        }
        //排序
        Arrays.sort(nums)
        out(nums)
        //遍历
        for (i in nums.indices) {
            out("i = $i")

            //当前值大于 0 则三数之和一定大于 0
            if (nums[i] > 0) {
                break
            }
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }
            //双指针区间
            var l = i + 1
            var r = nums.size - 1
            while (l < r) {
                val sum = nums[i] + nums[l] + nums[r]
                when {
                    sum == 0 -> {
                        ans.add(listOf(nums[i], nums[l], nums[r]))
                        while (l < r && nums[l] == nums[l + 1]) l++
                        while (l < r && nums[r] == nums[r - 1]) r--
                        l++
                        r--
                    }
                    sum > 0 -> {
                        r--
                    }
                    sum < 0 -> {
                        l++
                    }
                }
            }
        }
        return ans
    }

}