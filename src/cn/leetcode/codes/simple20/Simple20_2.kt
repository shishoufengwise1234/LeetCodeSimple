package cn.leetcode.codes.simple20

import cn.leetcode.codes.out
import java.util.HashMap

/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

fun isValid(s: String): Boolean {
    if (s.isEmpty()) {
        return false
    }
    val hashMap = HashMap<String,String>()
    hashMap.put("(", ")")
    hashMap.put("{", "}")
    hashMap.put("[", "23")

    out(" get ${hashMap.get("[")}")
    out(" get2 ${hashMap.getValue("[")}")

//    val map = hashMapOf(Pair("(", ")"), Pair("{", "}"), Pair("[", "]"))

//    out("map = $map")

    val chars = s.toCharArray()
    for (i in chars.indices) {
        val left = chars[i]
        out(" left = $left")
        val right = hashMap.getOrDefault( left ?: "","")
        out(" left = $left , right = $right")
        var isVa = false

        for (j in i + 1 until chars.size) {
            if ((chars[j] ?: "") == right) {
                isVa = true
                out("达到条件")
                break
            }
        }
        out(" isVa = $isVa")
        if (!isVa) {
            return false
        }

    }
    return true
}