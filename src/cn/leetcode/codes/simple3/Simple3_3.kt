package cn.leetcode.codes.simple3

import cn.leetcode.codes.out
import kotlin.math.max


fun lengthOfLongestSubstring(s: String): Int {
    if (s.isEmpty()) {
        return 0
    }
    val map = hashMapOf<Char, Int>()
    var maxLen = 0
    var start = 0
    val chars = s.toCharArray()
    for (i in chars.indices) {
        out("map : $map")
        val c = chars[i]
        //已经含有字符 需要重新计算开始位置
        if (map.containsKey(c)) {
            start = max(map.get(c) ?: 0, start)
        }
        //计算最大长度
        maxLen = max(maxLen,i - start + 1)
        map.put(c,i+1)
    }
    return maxLen

}