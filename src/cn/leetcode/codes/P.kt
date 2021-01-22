package cn.leetcode.codes

import cn.leetcode.codes.common.ListNode
import cn.leetcode.codes.common.TreeNode
import java.util.*

/**
 * Created by shishoufeng on 2020/4/27.
 *
 * desc : 日志打印相关
 *
 *
 */

fun out(any: Any) {
    println(any)
}

/**
 * 打印 ListNode 链表数据
 */
fun outListNode(listNode: ListNode?) {
    var curr = listNode
    val sb = StringBuilder()

    while (curr?.next != null) {
        sb.append(curr.`val`)
                .append(" > ")

        curr = curr.next
    }
    sb.append(curr?.`val`)
            .append(" > ")

    sb.append("NULL")

    out(sb.toString())
}

fun outTreeNote(root: TreeNode?) {
    // 如果是空直接返回空
    if (root == null) {
        out("null")
    }
    val res: MutableList<List<Int?>?> = LinkedList()
    // 每一层还是用一个双端队列来存储树节点，前面弹出，后面添加
    val deque: Deque<TreeNode> = LinkedList()
    deque.offer(root)
    // 用一个辅助变量来记录层数，看怎么如果以头节点为第1层的话，那么就是奇数层的数从尾部进行添加
    // 偶数层的数从头部增加，这也是本题的突破点所在。
    var lay = 0
    while (deque.size != 0) {
        lay++
        val len = deque.size
        val curlayer = LinkedList<Int?>()
        for (i in 0 until len) {
            val temp = deque.poll()
            if (temp.left != null) {
                deque.offer(temp.left)
            }
            if (temp.right != null) {
                deque.offer(temp.right)
            }
            if (lay % 2 == 0) {
                // 偶数层头部增加
                curlayer.offerFirst(temp.`val`)
            } else {
                // 否则奇数层尾部增加
                curlayer.offerLast(temp.`val`)
            }
        }
        res.add(curlayer)
    }
    out(res)
}