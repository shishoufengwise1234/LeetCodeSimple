package cn.leetcode.codes.simple34

class Simple34_2 {


    fun searchRange(nums: IntArray, target: Int): IntArray {
        val leftIndex = binarySearch(nums,target,true)
        val rightIndex = binarySearch(nums,target,false) - 1

        if (leftIndex <= rightIndex && rightIndex < nums.size && nums[leftIndex] == target && nums[rightIndex] == target){
            return intArrayOf(leftIndex,rightIndex)
        }
        return intArrayOf(-1,-1)
    }

    private fun binarySearch(nums: IntArray, target: Int, lower: Boolean): Int {
        //设置成数组长度
        var ans = nums.size
        var l = 0
        var r = nums.size - 1
        while (l <= r) {
            val mid = (l + r) / 2
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                r = mid - 1
                ans = mid
            } else {
                l = mid + 1
            }
        }
        return ans
    }

}