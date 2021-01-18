package cn.leetcode.codes.simple1

import java.util.HashMap

class Simple_1_2 {


    fun twoSum(nums: IntArray?, target: Int): IntArray {
        val hashMap = HashMap<Int, Int>()
        nums?.forEachIndexed { index, value ->
            val halfValue = target - value
            if (hashMap.containsKey(halfValue)) {
                return intArrayOf(hashMap.get(halfValue) ?: 0,index)
            }
            hashMap.put(value,index)
        }
        return intArrayOf(-1, -1)
    }
}