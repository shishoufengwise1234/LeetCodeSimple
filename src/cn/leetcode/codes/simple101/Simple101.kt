package cn.leetcode.codes.simple101

import cn.leetcode.codes.common.TreeNode
import cn.leetcode.codes.createTreeNode
import cn.leetcode.codes.out
import cn.leetcode.codes.outTreeNote
import java.util.*

fun main() {

//    val node = createTreeNode(intArrayOf(1,2,2,3,4,4,3))
    val node = createTreeNode(arrayOf(9, -42, -42, null, 76, 76, null, null, 13, null, 13))

    outTreeNote(node)

    val re = isSymmetric(node)
    val re2 = isSymmetric2(node)

    out("re = $re")
    out("re2 = $re2")


}

/*
101. 对称二叉树
给定一个二叉树，检查它是否是镜像对称的。



例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3


但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3


进阶：

你可以运用递归和迭代两种方法解决这个问题吗？
 */

fun isSymmetric(root: TreeNode?): Boolean {
    return isMirror(root, root)
}

fun isSymmetric2(root: TreeNode?): Boolean {
    return check(root, root)
}

//递归形式
fun isMirror(root: TreeNode?, root2: TreeNode?): Boolean {
    //都为null 是相同数据
    if (root == null && root2 == null) return true
    //一个为null 一个不为null 则数据不相同
    if (root == null || root2 == null) return false
    return root.`val` == root2.`val` && isMirror(root.left, root2.right) && isMirror(root.right, root2.left)
}

//迭代方式
fun check(root: TreeNode?, root2: TreeNode?): Boolean {
    //借助队列 将根节点入队两次
    val deque = LinkedList<TreeNode?>()
    var u = root
    var v = root2
    deque.offer(u)
    deque.offer(v)

    while (!deque.isEmpty()) {
        u = deque.poll()
        v = deque.poll()

        if (u == null && v == null) {
            continue
        }
        //两边值不相等
        if (u == null || v == null || (u?.`val` != v?.`val`)) {
            return false
        }
        deque.offer(u?.left)
        deque.offer(v?.right)

        deque.offer(u?.right)
        deque.offer(v?.left)
    }
    return true
}