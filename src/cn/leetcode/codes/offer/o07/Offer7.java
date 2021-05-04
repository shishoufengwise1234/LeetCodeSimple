package cn.leetcode.codes.offer.o07;

import cn.leetcode.codes.PKt;
import cn.leetcode.codes.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Offer7 {

    public static void main(String[] args) {

        //前序遍历 preorder = [3,9,20,15,7]
        //中序遍历 inorder = [9,3,15,20,7]

        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        TreeNode node = new Offer7().buildTree(preorder, inorder);

        PKt.outTreeNote(node);


    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();

        //将前序遍历放入map集合中
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTreeHelper(map,preorder,0, preorder.length, 0, inorder.length);
    }

    private TreeNode buildTreeHelper(Map<Integer, Integer> map, int[] preorder,int preStart, int preEnd,int inStart,int inEnd) {
        if (preStart == preEnd){
            return null;
        }
        //前序遍历的第一个元素是根节点
        int rootVal = preorder[preStart];

        TreeNode root = new TreeNode(rootVal);

        //左节点基准位置
        int rootLeft = map.getOrDefault(rootVal,0);
        //左子树个数
        int leftNum = rootLeft - inStart;

        root.left = buildTreeHelper(map, preorder,preStart + 1,leftNum + preStart + 1,inStart,rootLeft);
        root.right = buildTreeHelper(map, preorder, leftNum + preStart + 1 , preEnd, rootLeft + 1,inEnd );

        return root;
    }

}
