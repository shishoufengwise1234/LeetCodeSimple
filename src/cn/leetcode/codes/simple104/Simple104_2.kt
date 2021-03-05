package cn.leetcode.codes.simple104

import cn.leetcode.codes.common.TreeNode
import java.util.*
import kotlin.math.max

class Simple104_2 {


    //借助第三个公共参数
    private var ans: Int = 0
    fun maxDepth(root: TreeNode?): Int {
        depthLoop(root, 1)
        return ans
    }

    private fun depthLoop(node: TreeNode?, depth: Int) {
        if (node == null) return

        //已找到底部
        if (node.left == null && node.right == null) {
            ans = max(ans, depth)
        }
        depthLoop(node.left, depth + 1)
        depthLoop(node.right, depth + 1)
    }

    //迭代解法
    fun maxDepth2(root: TreeNode?): Int {
        if (root == null) return 0
        var ans = 0
        val deque = LinkedList<TreeNode>()
        deque.add(root)
        while (!deque.isEmpty()){
            //每一层数据,进行深度搜索
            var size = deque.size
            while (size > 0){
                val node = deque.poll()
                if (node.left != null){
                    deque.add(node.left)
                }
                if (node.right != null){
                    deque.add(node.right)
                }
                size--
            }
            //每层递增
            ans++
        }
        return ans
    }


}