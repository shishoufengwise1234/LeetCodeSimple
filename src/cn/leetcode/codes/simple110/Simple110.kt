package cn.leetcode.codes.simple110

import cn.leetcode.codes.common.TreeNode
import kotlin.math.abs


fun main() {


}


//fun isBalanced(root: TreeNode?): Boolean {
//    //空树 是平衡二叉树
//    if (root == null) return true
//
//
//
//}

private fun treeBalanced(root: TreeNode?,level:Int){
    if (root == null) return
    treeBalanced(root.left, level + 1)
}