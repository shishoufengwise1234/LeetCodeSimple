package cn.leetcode.codes.other;

import cn.leetcode.codes.CommonDataKt;
import cn.leetcode.codes.PKt;
import cn.leetcode.codes.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class SolutionTest {

    public static void main(String[] args) {

        TreeNode node = CommonDataKt.createTreeNode(new Integer[]{1, 3, 2, 5, 3, 9});

        int re = new SolutionTest().widthOfBinaryTree(node);

        PKt.out(re);

    }

    //2021.4.28 高途教育一面面试题
    //https://leetcode-cn.com/problems/maximum-width-of-binary-tree/
    /*
二叉树最大宽度
给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。

每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。

示例 1:
输入:
           1
          /   \
         3     2
        /  \       \
      5   3      9

输出: 4
解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。

示例 2:
输入:

          1
         /   \
        3    2
       /        \
      5         9
     /             \
   6              7
输出: 8
解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
* */

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        Deque<TreeNode> deque = new LinkedList<>();

        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            int childCount = 0;

            PKt.out(size);

            for (int i = 0; i < size; i++) {
                root = deque.remove();
                if (root.left != null) {
                    deque.add(root.left);
                } else {
                }
                childCount++;

                if (root.right != null) {
                    deque.add(root.right);
                } else {
                }
                childCount++;

            }
            ans = Math.max(ans, childCount);
        }
        return ans;
    }
}
