package cn.leetcode.codes.simple15

import java.util.*
import kotlin.collections.ArrayList

fun threeSum(nums: IntArray): List<List<Int>> {
    //不足三条数据 提前结束
    if (nums.size < 3) return arrayListOf()

    //排序
    Arrays.sort(nums)

    val list = ArrayList<ArrayList<Int>>()
    //外层循环
    for (i in nums.indices) {
        //当前值已经大于零 则另外两个值一定不为零 不符合条件 直接跳过本次循环
        if (nums[i] > 0) {
            break
        }
        //当前值 和 前一个值相同 需要去重操作
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue
        }
        //双指针区间范围
        var l = i + 1
        var r = nums.size - 1
        while (l < r) {
            val sum = nums[i] + nums[l] + nums[r]
            if (sum > 0) {
                r--
            } else if (sum < 0) {
                l++
            } else {
                list.add(arrayListOf(nums[i], nums[l], nums[r]))
                //左区间去重
                while (l < r && nums[l] == nums[l + 1]) l++
                //右区间去重
                while (l < r && nums[r] == nums[r - 1]) r--

                //独立相减
                l++
                r--
            }
        }
    }
    return list
}