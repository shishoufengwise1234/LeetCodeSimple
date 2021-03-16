package cn.leetcode.codes.simple104

import cn.leetcode.codes.common.TreeNode
import java.util.*
import kotlin.math.max

class Simple104_3 {

    //递归解法
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0

        return max(maxDepth(root.left), maxDepth(root.right)) + 1
    }


    //迭代解法
    fun maxDepth2(root: TreeNode?): Int {
        if (root == null) return 0

        var node = root
        val deque = LinkedList<TreeNode>()
        deque.add(node)
        var ans = 0
        while (!deque.isEmpty()) {
            var size = deque.size
            while (size > 0) {
                node = deque.poll()

                if (node.left != null) {
                    deque.add(node.left)
                }
                if (node.right != null) {
                    deque.add(node.right)
                }
                size--
            }
            ans++
        }
        return ans
    }

}