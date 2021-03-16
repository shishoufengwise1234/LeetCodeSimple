package cn.leetcode.codes.simple108;

import cn.leetcode.codes.PKt;
import cn.leetcode.codes.common.TreeNode;

public class Simple108 {


    public static void main(String[] args) {

        int[] nums = {-10, -3, 0, 5, 9};

        TreeNode node = new Simple108().sortedArrayToBST(nums);
        PKt.outTreeNote(node);


    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        return createTreeNode(nums, 0, nums.length - 1);
    }

    private TreeNode createTreeNode(int[] nums,int left,int right){
        //递归终止条件
        if (left > right){
            return null;
        }
        //选择数组中间值左边作为 根节点
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = createTreeNode(nums, left, mid - 1);
        root.right = createTreeNode(nums, mid + 1, right);
        return root;
    }
}
