package cn.leetcode.codes

/*
数组操作相关
 */




// 遍历 int[][]二维数组
fun toString(arrays: Array<IntArray>): String {
    val sb = StringBuilder()
    sb.append("[")
    for (i in arrays.indices) {
        sb.append("[")
        val ints = arrays[i]
        for (j in ints.indices) {
            sb.append(ints[j])
            if (j != ints.size - 1) {
                sb.append(",")
            }
        }
        sb.append("]")
        if (i != arrays.size - 1) {
            sb.append(" , ")
        }

    }
    sb.append("]")

    return sb.toString()
}

// 遍历 object[][]二维数组
fun toString(arrays: Array<Array<Any>>): String {
    val sb = StringBuilder()
    for (i in arrays.indices) {
        sb.append("[")
        val subArray = arrays[i]
        for (j in subArray.indices) {
            sb.append(subArray[j])
            if (j != subArray.size - 1) {
                sb.append(",")
            }
        }
        sb.append("]")
        if (i != arrays.size - 1) {
            sb.append(" , ")
        }
    }
    sb.append("]")

    return sb.toString()
}