package cn.leetcode.codes.simple105;

import cn.leetcode.codes.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Simple105_2 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }

        return buildTreeHelper(map,preorder,0, preorder.length, 0, inorder.length);
    }

    private TreeNode buildTreeHelper(Map<Integer, Integer> map, int[] preorder,int preStart,int preEnd, int inStart,int inEnd) {
        //遍历到尾部
        if (preStart == preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];

        TreeNode root = new TreeNode(rootVal);

        //根据根节点找到起点
        int inOrderStart = map.getOrDefault(rootVal, 0);
        //左子树个数
        int leftNum = inOrderStart - inStart;

        root.left = buildTreeHelper(map, preorder, preStart + 1, leftNum + preStart + 1,inStart, inOrderStart);
        root.right = buildTreeHelper(map, preorder,leftNum + preStart  + 1, preEnd , inOrderStart + 1, inEnd );

        return root;
    }


}
