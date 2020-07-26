package cn.leetcode.codes.simple102;

import cn.leetcode.codes.PKt;
import cn.leetcode.codes.common.TreeNode;

import javax.swing.*;
import java.awt.image.renderable.RenderableImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Simple102 {


    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);

        TreeNode r2 = new TreeNode(20);
        r2.left = new TreeNode(15);
        r2.right = new TreeNode(7);

        root.right = r2;

        List<List<Integer>> list = new Simple102().levelOrder(root);

        PKt.out(list);
    }

    /*
       102. 二叉树的层序遍历
给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。



示例：
二叉树：[3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]
     */

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> listRoots = new ArrayList<>();

        //利用栈进行记录层级打印位置
        LinkedList<TreeNode> queues = new LinkedList<>();
        queues.add(root);
        while (!queues.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            //打印栈内节点数据
            int size = queues.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queues.remove();
                temp.add(node.val);
                if (node.left != null){
                    queues.add(node.left);
                }
                if (node.right != null){
                    queues.add(node.right);
                }
            }
            listRoots.add(temp);
        }
        return listRoots;
    }




}
