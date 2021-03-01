package cn.leetcode.codes.simple242

import cn.leetcode.codes.out

fun main() {

    val s = ""
    val t = ""
//    val s = "anagram"
//    val t = "nagaram"

    out(isAnagram(s, t))

}

/*
242. 有效的字母异位词
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
说明:
你可以假设字符串只包含小写字母。

进阶:
如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */

fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) return false

    val sMap = hashMapOf<Char, Int>()
    val tMap = hashMapOf<Char, Int>()

    for (c in s) {
        if (sMap.containsKey(c)) {
            sMap[c]?.plus(1)?.let { sMap.put(c, it) }
        } else {
            sMap[c] = 1
        }
    }
    for (c in t) {
        if (tMap.containsKey(c)) {
            tMap[c]?.plus(1)?.let { tMap.put(c, it) }
        } else {
            tMap[c] = 1
        }
    }
    if (sMap.size != tMap.size) return false

    out(sMap)
    out(tMap)

    sMap.forEach { c ->
        val sV = sMap.get(c.key) ?: 0
        val tV = tMap.get(c.key) ?: 0
        if (sV != tV) {
            return false
        }
    }
    return true
}