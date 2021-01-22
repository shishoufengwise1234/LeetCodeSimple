package cn.leetcode.codes.simple5

//babad = bab / aba
fun longestPalindrome(s: String): String {
    if (s.isEmpty()){
        return ""
    }

    val map = hashMapOf<Char,Int>()
    val chars = s.toCharArray()
    for (i in chars.indices){
        val c = chars[i]
        if (map.containsKey(c)){

        }
    }

    return ""
}