package cn.leetcode.codes.simple102

import cn.leetcode.codes.common.TreeNode
import java.util.*
import kotlin.collections.ArrayList

class Simple102_2 {


    //递归解法
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val list = ArrayList<ArrayList<Int>>()
        if (root == null) return list
        levelLoop(1, root, list)
        return list
    }

    private fun levelLoop(index: Int, root: TreeNode?, list: ArrayList<ArrayList<Int>>) {
        //递归结束条件
        if (root == null) return

        if (list.size < index) {
            list.add(ArrayList())
        }
        list.get(index - 1).add(root.`val`)

        levelLoop(index + 1, root.left, list)
        levelLoop(index + 1, root.right, list)
    }

    //递归解法
    fun levelOrder2(root: TreeNode?): List<List<Int>> {
        val list = ArrayList<ArrayList<Int>>()
        if (root == null) return list

        //借助队列 使二叉树的每一层都压入栈内 进行遍历
        val deque = LinkedList<TreeNode>()
        deque.add(root)
        while (!deque.isEmpty()){
            val childList = ArrayList<Int>()
            val size = deque.size
            //遍历二叉树的每一层
            for (i in 1..size){
                val node = deque.poll()
                childList.add(node.`val`)
                if (node.left != null) {
                    deque.add(node.left)
                }
                if (node.right != null){
                    deque.add(node.right)
                }
            }
            list.add(childList)
        }
        return list
    }
}