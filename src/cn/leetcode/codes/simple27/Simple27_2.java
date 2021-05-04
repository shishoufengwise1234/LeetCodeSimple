package cn.leetcode.codes.simple27;

import java.util.Arrays;

public class Simple27_2 {

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //排序
        Arrays.sort(nums);

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
           if (nums[i] == val){
               nums[i] = -1;
           }else{
               count++;
           }
        }
        return count;
    }

    //双指针
    public int removeElement2(int[] nums, int val){
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int low = 0,hgt = nums.length - 1;

        while (low <= hgt){
            if (nums[low] == val){
                nums[low] = nums[hgt--];
            }else{
                low++;
            }
        }
        return low;
    }
}
