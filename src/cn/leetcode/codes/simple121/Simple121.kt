package cn.leetcode.codes.simple121

import cn.leetcode.codes.out
import kotlin.math.max


fun main() {

    val nums = intArrayOf(7,1,5,3,6,4)
//    val nums = intArrayOf(7,6,4,3,1)
    val max = maxProfit(nums)
    val max2 = maxProfit2(nums)

    out("max = $max")
    out("max2 = $max2")

}

/*

121. 买卖股票的最佳时机
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。

注意：你不能在买入股票前卖出股票。



示例 1:

输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
示例 2:

输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */

//暴力破解
fun maxProfit(prices: IntArray): Int {
    if (prices.isEmpty()) return 0

    var ans = 0
    var i = 0
    while (i < prices.size){
        var j = i+1
        while (j < prices.size) {
            val sum = prices[j] - prices[i]
            ans = max(sum, ans)
            j++
        }
        i++
    }
    return ans
}

//使用哨兵简化逻辑
fun maxProfit2(prices: IntArray): Int {
    if (prices.isEmpty()) return 0

    //最小买入时机
    var minProfit = Int.MAX_VALUE
    //最大卖出时机
    var maxProfit = 0

    for (n in prices){
        //找到最小买入时机
        if (n < minProfit){
            minProfit = n
        }else if (n - minProfit > maxProfit){   //如果此时卖出 大于之前最大值
            maxProfit = n - minProfit
        }
    }
    return maxProfit
}




























