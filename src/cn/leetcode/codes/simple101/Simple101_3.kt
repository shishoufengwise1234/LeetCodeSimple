package cn.leetcode.codes.simple101

import cn.leetcode.codes.common.TreeNode
import java.util.*

class Simple101_3 {


    //递归解法
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) return false

        return checkSymmetric(root, root)
    }

    private fun checkSymmetric(l: TreeNode?, r: TreeNode?): Boolean {
        if (l == null && r == null) return true
        if (l == null || r == null) return false
        if (l.`val` != r.`val`) return false

        return checkSymmetric(l.left, r.right) && checkSymmetric(l.right, r.left)
    }


    //迭代解法
    fun isSymmetric2(root: TreeNode?): Boolean {
        if (root == null) return false

        val deque = LinkedList<TreeNode>()
        var l = root
        var r = root
        deque.add(l)
        deque.add(r)

        while (!deque.isEmpty()) {
            l = deque.poll()
            r = deque.poll()

            //将两个节点同时为空的 跳过循环
            if (l == null && r == null){
                continue
            }
            if (l == null || r == null) return false
            if (l.`val` != r.`val`) return false

            deque.add(l.left)
            deque.add(r.right)

            deque.add(l.right)
            deque.add(r.left)
        }
        return true
    }


}