package cn.leetcode.codes.simple94

import cn.leetcode.codes.common.TreeNode
import cn.leetcode.codes.createTreeNode
import cn.leetcode.codes.out
import java.util.*
import kotlin.collections.ArrayList

fun main() {

    val nums = arrayOf<Int?>(1,2)
    val treeNode = createTreeNode(nums)
    val re = inorderTraversal(treeNode)
    val re2 = inorderTraversal2(treeNode)

    out("re = $re")
    out("re2 = $re2")

}


/*
94. 二叉树的中序遍历
给定一个二叉树的根节点 root ，返回它的 中序 遍历。



示例 1：


输入：root = [1,null,2,3]
输出：[1,3,2]
示例 2：

输入：root = []
输出：[]
示例 3：

输入：root = [1]
输出：[1]
示例 4：


输入：root = [1,2]
输出：[2,1]
示例 5：


输入：root = [1,null,2]
输出：[1,2]


提示：

树中节点数目在范围 [0, 100] 内
-100 <= Node.val <= 100


进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */


//递归解法 左子树 -> 根节点 -> 右子树
fun inorderTraversal(root: TreeNode?): List<Int> {
    val list = ArrayList<Int>()
    if (root == null) return list

    inorderLoop(root, list)
    return list
}

fun inorderLoop(node: TreeNode?, list: ArrayList<Int>) {
    if (node == null) return

    //先遍历左子树
    inorderLoop(node.left, list)
    //根节点
    list.add(node.`val`)
    //后遍历右子树
    inorderLoop(node.right, list)
}


//迭代解法
fun inorderTraversal2(root: TreeNode?): List<Int> {
    val list = ArrayList<Int>()
    if (root == null) return list

    var node = root
    //借助队列
    val deque = LinkedList<TreeNode>()
    while (!deque.isEmpty() || node != null){
        //持续遍历左子树
        while (node != null){
            deque.push(node)
            node = node.left
        }
        //从底部抽取出节点 再遍历
        node = deque.pop()
        list.add(node.`val`)
        node = node.right
    }
    return list
}

