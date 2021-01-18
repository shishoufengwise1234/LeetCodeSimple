package cn.leetcode.codes.simple1

import java.util.*

/*
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

/*


解题思路：

1. 对于数组内部两个值求和 一定会涉及到遍历、有可能集合是无序的、所以 必须采用遍历、而且是双层for循环进行遍历、才能数组里全部判断不能遗漏、
所以 外城循环即 正常循环数量、内层循环就是 外层循环的 -1





 */


fun main(array: Array<String>) {


    val intArr = intArrayOf(2,3,9,7,23,78)
//    val intArr = intArrayOf(3, 3)

    val re1 = printIndex(intArr, 26)
    val re2 = Simple_1_2().twoSum(intArr,26)

    println(" re1 = ${Arrays.toString(re1)}")
    println(" re2 = ${Arrays.toString(re2)}")

}











// kotlin 实现版本
private fun printIndex(intArr: IntArray, target: Int): IntArray {

    var text: String? = null
    var a: Int = 0
    var b: Int = 0
    val re = IntArray(2)

    for (i in intArr.indices) {
        println(" i = $i")

        for (j in i + 1..intArr.size-1) {
            if (intArr[i] + intArr[j] == target) {
                a = i
                b = j
                text = " i = $i ,j = $j"

                re[0] = i
                re[1] = j
            }
        }
    }

    println("查询到结果 ：text = $text , 数据： ${intArr[a]} ,${intArr[b]}")


    return re
}

