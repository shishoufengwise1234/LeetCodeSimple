package cn.leetcode.codes.simple26

/*

给定 nums = [0,0,1,1,1,2,2,3,3,4],

函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。

你不需要考虑数组中超出新长度后面的元素。

 */

//快慢指针问题
fun removeDuplicates(nums: IntArray): Int {
    var i = 0
    for (l in 1 until nums.size){
        if (nums[l] != nums[i]) {
            //先进行加加操作
            i++
            nums[i] = nums[l]
        }
    }
    return i+1
}