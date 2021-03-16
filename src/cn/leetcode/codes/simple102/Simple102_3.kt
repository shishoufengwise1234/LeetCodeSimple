package cn.leetcode.codes.simple102

import cn.leetcode.codes.common.TreeNode
import java.util.*
import kotlin.collections.ArrayList

class Simple102_3 {


    //广度搜索 BFS
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val list = ArrayList<ArrayList<Int>>()
        if (root == null) return list

        var node = root
        val deque = LinkedList<TreeNode>()
        deque.add(node)
        while (!deque.isEmpty()) {

            val size = deque.size
            val childList = ArrayList<Int>()
            for (i in 0 until size) {
                node = deque.poll()
                childList.add(node.`val`)

                if (node.left != null) {
                    deque.add(node.left)
                }
                if (node.right != null) {
                    deque.add(node.right)
                }
            }
            list.add(childList)
        }

        return list
    }

    //深度搜索 DFS 递归解法
    fun levelOrder2(root: TreeNode?): List<List<Int>> {
        val list = ArrayList<ArrayList<Int>>()
        if (root == null) return list

        levelOrderLoop(root, list, 1)
        return list
    }

    private fun levelOrderLoop(node: TreeNode?, list: ArrayList<ArrayList<Int>>, level: Int) {
        if (node == null) return

        var childList = list.getOrNull(level - 1)
        if (childList == null){
            childList = ArrayList()
            list.add(childList)
        }
        childList.add(node.`val`)

        val i = level + 1
        levelOrderLoop(node.left, list, i)
        levelOrderLoop(node.right, list, i)
    }


}