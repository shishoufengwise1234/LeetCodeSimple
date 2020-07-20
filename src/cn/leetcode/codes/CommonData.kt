package cn.leetcode.codes

import cn.leetcode.codes.common.ListNode

/**
 * 获取指定数量的 链表数据
 */
fun getListNode(vararg ints : Int) : ListNode?{
    if (ints.isEmpty())
        return null
    var pro = ListNode(ints[0])
    for (e in ints){
        out(e)
        val temp = ListNode(e)

    }
    return pro.next
}
