package cn.leetcode.codes.sort

/**
 * 交换数据
 */
fun swap(nums:IntArray,i:Int,j:Int){
    val temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp;
}

