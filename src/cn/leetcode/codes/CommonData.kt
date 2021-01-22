package cn.leetcode.codes

import cn.leetcode.codes.common.ListNode
import cn.leetcode.codes.common.TreeNode
import java.util.*

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

fun createTreeNode(array: Array<Int?>?): TreeNode? {
    if (array == null) {
        return null
    }
    val root = array[0]?.let {
        TreeNode(it)
    }
    val queue: Queue<TreeNode> = LinkedList()
    queue.add(root)
    var isLeft = true
    for (i in 1 until array.size) {
        val node = queue.peek() ?: null
        if (isLeft) {
            node?.left = array[i]?.let {
                TreeNode(it)
            }
            queue.offer(node?.left)
            isLeft = false
        } else {
            node?.right = array[i]?.let {
                TreeNode(it)
            }
            queue.offer(node?.right)
            queue.poll()
            isLeft = true
        }
    }
    return root
}

