package cn.leetcode.codes.simple83

import cn.leetcode.codes.common.ListNode

class Simple83_2 {

    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head == null){
            return null
        }
        var curr = head
        while (curr?.next != null){
            curr = if (curr.`val` == curr.next.`val`){
                curr.next.next
            }else {
                curr.next
            }
        }
        return curr
    }
}