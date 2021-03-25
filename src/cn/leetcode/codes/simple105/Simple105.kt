package cn.leetcode.codes.simple105

import cn.leetcode.codes.common.TreeNode
import cn.leetcode.codes.outTreeNote

fun main() {

    val preOrder = intArrayOf(3,9,20,15,7)
    val inOrder = intArrayOf(9,3,15,20,7)

    val treeNode = buildTree(preOrder,inOrder)

    outTreeNote(treeNode)

}

/**
 * 刷题情况
 *
 * 题目地址：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * 1 刷是否通过：
 *
 *
 * 2 刷是否完成：
 *
 *
 * 3 刷是否完成：
 *
 *
 * 4 刷是否完成：
 *
 *
 * 5 刷是否完成：
 *
 * 最优解析：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--22/
 *
 */

/*
根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder =[3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

val map = HashMap<Int, Int>()

fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    if (preorder.size != inorder.size) {
        return null
    }
    //使用map存储数据
    preorder.forEachIndexed { p, i ->
        map.put(p, i)
    }
    return buildTreeHelper(preorder, 0, preorder.size, inorder, 0, inorder.size)
}

private fun buildTreeHelper(preorder: IntArray, preStart: Int, preEnd: Int, inorder: IntArray, inStart: Int, inEnd: Int): TreeNode? {
    if (preStart == preEnd) {
        return null
    }
    //前序遍历的根节点
    val preRoot = preorder[preStart]

    val root = TreeNode(preRoot)

    val inOrderRootStart = map.getOrDefault(preRoot, 0)
    val leftNum = inOrderRootStart - inStart

    root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftNum + 1, inorder, inStart, inOrderRootStart)
    root.right = buildTreeHelper(preorder, preStart + leftNum + 1, preEnd, inorder, inOrderRootStart + 1, inEnd)

    return root
}