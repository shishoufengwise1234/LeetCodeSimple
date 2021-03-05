package cn.leetcode.codes.simple112

import cn.leetcode.codes.common.TreeNode
import cn.leetcode.codes.createTreeNode
import cn.leetcode.codes.out


fun main() {

    val treeNode = createTreeNode(arrayOf(1,2,3))
    val re1 = hasPathSum(treeNode,5)
    out("re1 = $re1")

}


//递归解法
fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    if (root == null) return false

    //递归到最深处 检查当前值是否和和相同
    if (root.left == null && root.right == null) {
        return targetSum == root.`val`
    }
    //
    return hasPathSum(root.left, targetSum - root.`val`) || hasPathSum(root.right, targetSum - root.`val`)
}


