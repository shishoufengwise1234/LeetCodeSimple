package cn.leetcode.codes.simple104

import cn.leetcode.codes.common.TreeNode
import cn.leetcode.codes.createTreeNode
import cn.leetcode.codes.out
import java.util.*
import kotlin.math.max


fun main() {

    val node = createTreeNode(arrayOf(3, 9, 20, null, null, 15, 7))

    val re = maxDepth(node)
    val re2 = maxDepth2(node)
    val re3 = Simple104_2().maxDepth(node)
    val re4 = Simple104_2().maxDepth2(node)

    out("re = $re")
    out("re2 = $re2")
    out("re3 = $re3")
    out("re4 = $re4")

}

/*
104. 二叉树的最大深度
给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。
 */

fun maxDepth(root: TreeNode?): Int {
    if (root == null) return 0

    val left = maxDepth(root.left)
    val right = maxDepth(root.right)

    return max(left, right) + 1
}

fun maxDepth2(root: TreeNode?): Int {
    if (root == null) return 0

    //加入根节点
    val deque = LinkedList<TreeNode?>()
    deque.offer(root)

    //最大深度
    var ans = 0

    while (!deque.isEmpty()){

        //当前层进行遍历
        var size = deque.size
        while (size > 0){
            //弹出当前层节点数据
            val currentNode = deque.poll()

            //存在左子树 则继续加入栈内 进行搜索
            if (currentNode?.left != null){
                deque.offer(currentNode.left)
            }
            //存在右子树
            if (currentNode?.right != null){
                deque.offer(currentNode.right)
            }
            //层次递减
            size --
        }
        ans++
    }
    return ans
}