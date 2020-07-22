package cn.leetcode.codes.simple88;

public class Simple88_2 {


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null){
            return;
        }
        //将num2 数据放入 num1中
        int index = nums1.length - 1;
        for (int value : nums2) {
            nums1[index--] = value;
        }
        //使用冒泡排序重新排序
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums1.length - i - 1; j++) {
                if (nums1[j] > nums1[j + 1]){
                    int temp = nums1[j];
                    nums1[j] = nums1[j + 1];
                    nums1[j + 1] = temp;
                }
            }
        }

    }
}
