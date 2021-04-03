package cn.leetcode.codes.simple215;

import cn.leetcode.codes.PKt;
import cn.leetcode.codes.sort.DataSort;
import cn.leetcode.codes.sort.DataSort1;
import sun.lwawt.LWComponentPeer;

import java.util.Arrays;

public class Simple215 {

    /**
     * 刷题情况
     * <p>
     * 题目地址：https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
     * <p>
     * 1 刷是否通过：
     * <p>
     * <p>
     * 2 刷是否完成：
     * <p>
     * <p>
     * 3 刷是否完成：
     * <p>
     * <p>
     * 4 刷是否完成：
     * <p>
     * <p>
     * 5 刷是否完成：
     * <p>
     * 最优解析：
     */

    public static void main(String[] args) {

//        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
//        int[] nums = {3,2,1,5,6,4};
        int[] nums = {2,1};
        int k = 1;
        Simple215 simple215 = new Simple215();
        int re = simple215.findKthLargest(nums, k);

        PKt.out("nums1 = " + Arrays.toString(nums));
        PKt.out("re = " + re);


    }

    /*
    215. 数组中的第K个最大元素
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:

输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
示例 2:

输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
说明:

你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
     */

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    //快速排序
    private void quickSort(int[] nums, int low, int hgt) {
        if (low >= hgt) {
            return;
        }
        //双指针划分区间
        int left = low;
        int right = hgt;

        int key = nums[left];
        while (left < right) {
            //将右指针向前移动
            while (left < right && nums[right] >= key) {
                right--;
            }
            //将左指针向后移动
            while (left < right && nums[left] <= key) {
                left++;
            }
            //交换出中间值
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        //交换两边数值
        int temp = nums[low];
        nums[low] = nums[left];
        nums[left] = temp;

        //针对两个区间进行排序
        quickSort(nums, low, left - 1);
        quickSort(nums, left + 1, hgt);
    }

}
