package cn.leetcode.codes.simple35;

import cn.leetcode.codes.PKt;

public class Simple35 {


    /**
     *
     * 刷题情况
     *
     * 题目地址：
     *
     * 题解地址:
     *
     *https://leetcode-cn.com/problems/search-insert-position/
     *
     * 1 刷是否通过：no
     *
     *
     * 2 刷是否完成：no
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
     *
     *
     */

    public static void main(String[] args) {
//        int[] ints = new int[]{1,3,5,6};
        int[] ints = new int[]{1,3,5,6,9,78};
        int index = new Simple35().searchInsert(ints,10);

        PKt.out("index = "+index);
    }

    /*
    35. 搜索插入位置
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。

示例 1:

输入: [1,3,5,6], 5
输出: 2
示例 2:

输入: [1,3,5,6], 2
输出: 1
示例 3:

输入: [1,3,5,6], 7
输出: 4
示例 4:

输入: [1,3,5,6], 0
输出: 0
     */
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length <= 0){
            return 0;
        }
        int low = 0,height = nums.length - 1;
        while (low <= height){
            int mid = (height + low) / 2;
            // 如果正好位于 中间元素
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){  //如果中间值 大于目标值
                height = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }



}
