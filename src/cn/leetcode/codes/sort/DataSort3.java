package cn.leetcode.codes.sort;

import java.util.Arrays;

public class DataSort3 implements DataSort {


    @Override
    public void bubbleSort(int[] nums) {

    }

    @Override
    public void insertionSort(int[] nums) {

    }

    @Override
    public void selectSort(int[] nums) {

    }

    @Override
    public int[] margeSort(int[] nums) {
        if (nums == null || nums.length <= 1){
            return nums;
        }
        int half = nums.length >> 1;

        int[] left = Arrays.copyOfRange(nums,0 , half);
        int[] right = Arrays.copyOfRange(nums, half, nums.length);

        return margeToArray(margeSort(left),margeSort(right));
    }

    private int[] margeToArray(int[] left,int[] right){
        int i = 0,j = 0,k = 0;
        int[] ans = new int[left.length + right.length];

        while (i < left.length && j < right.length){
            if (left[i] <= right[j]){
                ans[k++] = left[i++];
            }else{
                ans[k++] = right[j++];
            }
        }
        while (i < left.length){
            ans[k++] = left[i++];
        }
        while (j < right.length){
            ans[k++] = right[j++];
        }
        return ans;
    }

    @Override
    public void quickSort(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        quickLoop(nums, 0, nums.length  - 1);
    }

    private void quickLoop(int[] nums,int low,int hgt){
        if (low >= hgt){
            return;
        }
        int left = low;
        int right = hgt;
        int key = nums[left];

        while (left < right){
            //右指针向前走
            while (left < right && nums[right] >= key){
                right--;
            }
            //左指针向后走
            while (left < right && nums[left] <= key){
                left++;
            }
            //交换中间位置
            if (left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        int temp = nums[low];
        nums[low] = nums[left];
        nums[left] = temp;

        //分别对左右区间进行排序
        quickLoop(nums, low, left  - 1);
        quickLoop(nums, left + 1, hgt);
    }
}
