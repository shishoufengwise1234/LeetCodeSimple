package cn.leetcode.codes

import cn.leetcode.codes.common.ListNode

/**
 * Created by shishoufeng on 2020/4/27.
 *
 * desc : 日志打印相关
 *
 *
 */

fun out(string: String){
    println(string)
}

/**
 * 打印 ListNode 链表数据
 */
fun outListNode(listNode: ListNode?){
    var curr = listNode
    val sb = StringBuilder()

    while (curr?.next != null){
        sb.append(curr.`val`)
            .append(" > ")

        curr = curr.next
    }
    sb.append(curr?.`val`)
        .append(" > ")

    sb.append("NULL")

    out(sb.toString())
}