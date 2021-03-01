package cn.leetcode.codes.simple1



//三刷
fun twoSum(nums: IntArray?, target: Int): IntArray {
    val map = hashMapOf<Int, Int>()
    //不用先加入map中
//    nums?.forEachIndexed { i, n ->
//        map[n] = i
//    }
    nums?.forEachIndexed { index, n ->
        val s = target - n
        if (map.containsKey(s)) {
            return intArrayOf(index, map.getOrDefault(s, 0))
        }
        map[n] = index
    }
    return intArrayOf(-1, -1)
}