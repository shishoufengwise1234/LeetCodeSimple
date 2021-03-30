package cn.leetcode.codes.simple22

import cn.leetcode.codes.out

/**
 * 刷题情况
 *
 * 题目地址：https://leetcode-cn.com/problems/generate-parentheses/
 *
 * 1 刷是否通过：没有
 *
 *
 * 2 刷是否完成：
 *
 *
 * 3 刷是否完成：
 *
 *
 * 4 刷是否完成：
 *
 *
 * 5 刷是否完成：
 *
 * 最优解析：https://leetcode-cn.com/problems/generate-parentheses/solution/gua-hao-sheng-cheng-by-leetcode-solution/
 *
 * 官方下方 第一条评论
 *
 */

fun main() {

    val n = 1
    val re = generateParenthesis(n)

    out(re)

}

/*
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

 

示例 1：

输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]
示例 2：

输入：n = 1
输出：["()"]
 

提示：

1 <= n <= 8

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/generate-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


fun generateParenthesis(n: Int): List<String> {
    val list = ArrayList<String>()

    if (n <= 0) {
        return list
    }
    generate(list,"", n, n)
    return list
}

private fun generate(list: ArrayList<String>, str: String, left: Int, right: Int) {
    //左右两边都使用完
    if (left == 0 && right == 0) {
        list.add(str)
        return
    }
    //左右两边相同 先添加左括号
    if (left == right){
        generate(list, "$str(",left - 1,right)
    }else{
        //左边还有括号 先添加左括号
        if (left > 0){
            generate(list,"$str(",left - 1,right)
        }
        //添加右括号
        generate(list,"$str)",left,right - 1)
    }
}
