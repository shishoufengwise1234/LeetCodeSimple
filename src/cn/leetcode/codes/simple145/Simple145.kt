package cn.leetcode.codes.simple145

import cn.leetcode.codes.common.TreeNode
import cn.leetcode.codes.createTreeNode
import cn.leetcode.codes.out
import java.util.*
import kotlin.collections.ArrayList

fun main() {

    val nums = arrayOf<Int?>(1,2,3)
    val treeNode = createTreeNode(nums)
    val re = postorderTraversal(treeNode)
    val re2 = postorderTraversal2(treeNode)

    out("re = $re")
    out("re2 = $re2")


}

/*
145. 二叉树的后序遍历
给定一个二叉树，返回它的 后序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [3,2,1]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */

//递归解法  后序遍历 左子树 -> 右子树 -> 根节点
fun postorderTraversal(root: TreeNode?): List<Int> {
    val list = ArrayList<Int>()
    if (root == null) return list

    postorder(root,list)
    return list
}
fun postorder(node: TreeNode?,list: ArrayList<Int>){
    if (node == null) return

    postorder(node.left,list)
    postorder(node.right,list)
    list.add(node.`val`)
}

//迭代解法
fun postorderTraversal2(root: TreeNode?): List<Int> {
    val list = ArrayList<Int>()
    if (root == null) return list

    //借助队列实现遍历
    var node = root
    var prev:TreeNode? = null
    val deque = LinkedList<TreeNode>()
    while (!deque.isEmpty() || node != null){
        //持续遍历左子树
        while (node != null){
            deque.push(node)
            node = node.left
        }
        node = deque.pop()
        //持续遍历右子树
        if (node.right == null || node.right == prev){
            list.add(node.`val`)
            prev = node
            node = null
        }else{
            deque.push(node)
            node = node.right
        }
    }
    return list
}
