package cn.leetcode.codes.simple35;

import cn.leetcode.codes.PKt;

public class Simple35_2 {


    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int index = new Simple35_2().searchInsert(nums,0);

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
            return -1;
        }
        int low = 0,hgt = nums.length - 1;
        while (low <= hgt){
            int mid = low + ((hgt - low) >> 1);
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                low = mid + 1;
            }else{
                hgt = mid - 1;
            }
        }
        return low;
    }
}
