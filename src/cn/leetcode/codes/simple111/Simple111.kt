package cn.leetcode.codes.simple111

import cn.leetcode.codes.common.TreeNode
import cn.leetcode.codes.createTreeNode
import cn.leetcode.codes.out
import java.util.*
import kotlin.math.min

fun main() {

    val nums = arrayOf<Int?>(3, 9, 20, 15, 7)
    val treeNode = createTreeNode(nums)

    val re = minDepth(treeNode)
    val re2 = minDepth2(treeNode)

    out("re = $re")
    out("re2 = $re2")

}
/*
111. 二叉树的最小深度
给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明：叶子节点是指没有子节点的节点。



示例 1：


输入：root = [3,9,20,null,null,15,7]
输出：2
示例 2：

输入：root = [2,null,3,null,4,null,5,null,6]
输出：5


提示：

树中节点数的范围在 [0, 105] 内
-1000 <= Node.val <= 1000
 */

fun minDepth(root: TreeNode?): Int {
    if (root == null) return 0

    //遍历到底部了
    if (root.left == null && root.right == null) {
        return 1
    }
    var minValue = Int.MAX_VALUE
    //遍历左子树
    if (root.left != null) {
        minValue = min(minValue, minDepth(root.left))
    }
    //递归右子树
    if (root.right != null) {
        minValue = min(minValue, minDepth(root.right))
    }
    //加上根节点层数据
    return minValue + 1
}

//定义查询节点
class QueueNode(var node: TreeNode,var death: Int = 0)

//迭代解法 广度搜索
fun minDepth2(root: TreeNode?):Int{
    if (root == null) return 0

    val deque = LinkedList<QueueNode>()
    deque.add(QueueNode(root,1))
    while (!deque.isEmpty()){
        val queue = deque.poll()
        val node = queue.node
        val death = queue.death
        //到达第一个 左右节点都是null 情况 说明找到了最小的深度
        if (node.left == null && node.right == null){
            return death
        }

        //继续将左右子树压入栈内 进行遍历
        if (node.left != null){
            deque.add(QueueNode(node.left,death + 1))
        }
        if (node.right != null){
            deque.add(QueueNode(node.right,death + 1))
        }
    }
    //没有找到
    return 0
}











//fun minDepth2(root: TreeNode?): Int {
//    if (root == null) return 0
//
//    var node = root
//    val deque = LinkedList<TreeNode>()
//    deque.add(node)
//    var ans = 0
//    while (!deque.isEmpty()) {
//        var size = deque.size
//        while (size > 0) {
//            node = deque.poll()
//            if (node.left != null) {
//                deque.add(node.left)
//            }
//            if (node.right != null) {
//                deque.add(node.right)
//            }
//            size--
//        }
//        ans++
//    }
//    return ans
//}

