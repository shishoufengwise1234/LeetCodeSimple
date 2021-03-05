package cn.leetcode.codes.simple144

import cn.leetcode.codes.common.TreeNode
import cn.leetcode.codes.createTreeNode
import cn.leetcode.codes.out
import cn.leetcode.codes.outTreeNote
import java.util.*
import kotlin.collections.ArrayList

fun main() {

    val nums = arrayOf<Int?>(1, 4, 3, 2)
    val treeNode = createTreeNode(nums)
    outTreeNote(treeNode)

    val re = preorderTraversal(treeNode)
    val re2 = preorderTraversal2(treeNode)
    out("re = $re")
    out("re2 = $re2")

}

/*
144. 二叉树的前序遍历
给你二叉树的根节点 root ，返回它节点值的 前序 遍历。



示例 1：


输入：root = [1,null,2,3]
输出：[1,2,3]
示例 2：

输入：root = []
输出：[]
示例 3：

输入：root = [1]
输出：[1]
示例 4：


输入：root = [1,2]
输出：[1,2]
示例 5：


输入：root = [1,null,2]
输出：[1,2]


提示：

树中节点数目在范围 [0, 100] 内
-100 <= Node.val <= 100


进阶：递归算法很简单，你可以通过迭代算法完成吗？
 */


//递归解法
//前序遍历 根节点 -> 左子树 -> 右子树
fun preorderTraversal(root: TreeNode?): List<Int> {
    val list = ArrayList<Int>()

    if (root == null) return list
    traversal(root, list)
    return list
}

fun traversal(root: TreeNode?, list: ArrayList<Int>) {
    if (root == null) return
    list.add(root.`val`)

    traversal(root.left, list)
    traversal(root.right, list)
}

//迭代解法
fun preorderTraversal2(root: TreeNode?): List<Int> {
    val list = ArrayList<Int>()
    if (root == null) return list

    //使用队列存放树
    val deque = LinkedList<TreeNode>()

    var node = root
    while (!deque.isEmpty() || node != null) {

        while (node != null){
            //加入当前根节点数据
            list.add(node.`val`)

            //将当前节点 压入栈内
            deque.push(node)
            //继续遍历左子树
            node = node.left
        }
        //从底部弹出节点
        node = deque.pop()
        //遍历右子树
        node = node.right
    }
    return list
}