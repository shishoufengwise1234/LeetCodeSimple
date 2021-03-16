package cn.leetcode.codes.simple70

class Simple70_2 {


    // 1 = 1
    // 2 = 2
    // 3 = 3
    // 4 = 5

    // n = n - 1 + n - 2
    fun climbStairs(n: Int): Int {
        if (n <= 2){
            return n
        }
        val stairs = IntArray(n)
        stairs[0] = 1
        stairs[1] = 2
        for (i in 2 until n){
            stairs[i] = stairs[i - 1] + stairs[i - 2]
        }
        return stairs[n - 1]
    }

}