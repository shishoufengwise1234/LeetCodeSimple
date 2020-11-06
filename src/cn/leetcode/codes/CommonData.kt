package cn.leetcode.codes

import cn.leetcode.codes.common.ListNode

//根据数组生成链表
fun createListNode(vararg ints: Int): ListNode? {
    //头指针
    val pre = ListNode(0)
    var curr = pre
    for (i in ints) {
        val temp = ListNode(i)
        curr.next = temp
        curr = curr.next
    }
    return pre.next
}
