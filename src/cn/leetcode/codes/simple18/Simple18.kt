package cn.leetcode.codes.simple18

import cn.leetcode.codes.out
import java.util.*

fun main() {

//    val nums = intArrayOf(1, 0, -1, 0, -2, 2)
//    val nums = intArrayOf(-2,-1,-1,1,1,2,2)
    val nums = intArrayOf(1,0,-1,0,-2,2)
    val s = fourSum(nums, 0)

    out("s = $s")
}

/*
18. 四数之和
给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

注意：

答案中不可以包含重复的四元组。

示例：

给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 */

fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    val list = mutableListOf<List<Int>>()
    if (nums.size < 4) {
        return list
    }
    //排序
    Arrays.sort(nums)

    val len = nums.size

    for (i in 0 until len - 3) {
        //如果和本次循环数据 和上次数据一样 没有必要再次循环
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue
        }
        //前三个值都大于给定值 后面没有必要再比较
        if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
            break
        }
        //后三个值小于给定值 直接开始下一次循环即可
        if (nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) {
            continue
        }
        for (j in i + 1 until len - 2) {
            //如果和本次循环数据 和上次数据一样 没有必要再次循环
            if (j > i + 1 && nums[j] == nums[j - 1]) {
                continue
            }
            if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                break
            }
            if (nums[i] + nums[j] + nums[len - 2] + nums[len - 1] < target) {
                continue
            }
            //双指针
            var l = j + 1
            var r = nums.size - 1
            while (l < r) {
                val sum = nums[i] + nums[j] + nums[l] + nums[r]
                when {
                    sum == target -> {
                        list.add(listOf(nums[i], nums[j], nums[l], nums[r]))
                        //去重
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++
                        }
                        l++
                        //去重
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--
                        }
                        r--
                    }
                    sum < target -> {
                        l++
                    }
                    sum > target -> {
                        r--
                    }
                }
            }
        }
    }
    return list
}






