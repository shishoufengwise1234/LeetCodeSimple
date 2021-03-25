package cn.leetcode.codes.simple88;

import java.util.Arrays;

public class Simple88_3 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = nums1.length - 1;
        //先将第二个数组添加至第一个数组中
        while (i < n && j >= 0) {
            nums1[j--] = nums2[i++];
        }
        //排序
        Arrays.sort(nums1);
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        //nums1 末尾指针位置
        int len = m + n - 1;

        //不断比较两个数组最后的元素大小
        while (len1 >= 0 && len2 >= 0){
            nums1[len--] = nums1[len1] < nums2[len2] ? nums2[len2--] : nums1[len1--];
        }
        System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
    }

}
