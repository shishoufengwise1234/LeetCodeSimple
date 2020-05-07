package cn.leetcode.codes.simple88;

import cn.leetcode.codes.PKt;

import java.util.Arrays;

public class Simple88 {


    public static void main(String[] args){

        Simple88 simple88 = new Simple88();

        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};

        simple88.merge(nums1,3,nums2,3);
    }



/*

88. 合并两个有序数组
给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。


说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 
示例:

输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */


    public void merge(int[] nums1, int m, int[] nums2, int n) {

        System.arraycopy(nums2,0,nums1,m,n);

        PKt.out("nums1 = "+Arrays.toString(nums1));
        PKt.out("nums2 = "+Arrays.toString(nums2));

        Arrays.sort(nums1);
        PKt.out("sort : nums1 = "+Arrays.toString(nums1));


    }

}