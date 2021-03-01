package cn.leetcode.codes.simple18

import java.util.*
import kotlin.collections.ArrayList


class Simple18_2 {


    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val list = ArrayList<ArrayList<Int>>()
        if (nums.size < 4) return list

        //对数组进行排序
        Arrays.sort(nums)

        val count = nums.size

        //外层循环
        for (i in 0 until count - 3) {

            //跳过本次循环
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }
            //由于是排序之后的数组 如果前四个数据已经大于 target 没有必要进行在循环
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break
            }
            //如果后三个数据 小于 target 则没有必要再循环
            if (nums[i] + nums[count - 1] + nums[count - 2] + nums[count - 3] < target) {
                continue
            }

            //第二层外层循环
            for (j in i + 1 until count - 2) {

                //去重 后一个数据 和前一个相同
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue
                }
                //前三个数据已大于 target 没有必要再循环
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target){
                    break
                }
                //如果后三个数据已经小于 target 没有必要再循环下去
                if (nums[i] + nums[j] + nums[count - 1] + nums[count - 2] < target){
                    continue
                }

                //双指针区间
                var l = j + 1
                var r = nums.size - 1

                while (l < r) {
                    val sum = nums[i] + nums[j] + nums[l] + nums[r]

                    when {
                        sum > target -> {
                            r--
                        }
                        sum < target -> {
                            l++
                        }
                        else -> {
                            list.add(arrayListOf(nums[i], nums[j], nums[l], nums[r]))

                            //去重
                            while (l < r && nums[l] == nums[l + 1]) l++
                            while (l < r && nums[r] == nums[r - 1]) r--

                            r--
                            l++
                        }
                    }
                }
            }
        }
        return list
    }
}