package cn.leetcode.codes.simple101

import cn.leetcode.codes.common.TreeNode
import java.util.*

class Simple101_2 {

    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) return true

        return check(root.left, root.right)
    }

    fun check(l: TreeNode?, r: TreeNode?): Boolean {
        if (l == null && r == null) return true
        if (l == null || r == null) return false
        if (l.`val` != r.`val`) return false

        return check(l.left, r.right) && check(l.right, r.left)
    }


    //利用队列 遍历方式验证
    fun isSymmetric2(root: TreeNode?): Boolean {
        return check2(root,root)
    }

    fun check2(root: TreeNode?, root2: TreeNode?): Boolean {
        val deque = LinkedList<TreeNode?>()

        var l = root
        var r = root2

        deque.add(l)
        deque.add(r)

        //队列不为空就一直遍历下去
        while (!deque.isEmpty()){
            //紧接着弹出两个节点
            l = deque.poll()
            r = deque.poll()

            //节点全部为空 直接跳过当前循环
            if (l == null && r == null) continue

            //两个节点的数据不相同 直接停止循环
            if ((l == null || r == null) || (l.`val` != r.`val`)) return false

            deque.add(l.left)
            deque.add(r.right)

            deque.add(l.right)
            deque.add(r.left)
        }
        return true
    }

}