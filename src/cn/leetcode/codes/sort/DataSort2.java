package cn.leetcode.codes.sort;

import java.util.Arrays;

public class DataSort2 implements DataSort {

    @Override
    public void bubbleSort(int[] nums) {

        for (int i = 0;i < nums.length;i++){
            boolean isSwap = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]){
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;

                    isSwap = true;
                }
            }
            if (!isSwap){
                break;
            }
        }

    }

    @Override
    public void insertionSort(int[] nums) {

    }

    @Override
    public void selectSort(int[] nums) {

    }

    @Override
    public int[] margeSort(int[] nums) {
        return sortNum(nums);
    }

    private int[] sortNum(int[] nums){
        if (nums == null || nums.length <= 1){
            return nums;
        }
        int half = nums.length >> 1;
        int[] left = Arrays.copyOfRange(nums, 0, half);
        int[] right = Arrays.copyOfRange(nums, half, nums.length);

        return margeToArray(sortNum(left), sortNum(right));
    }

    private int[] margeToArray(int[] left,int[] right){
        int i = 0,j = 0,k = 0;
        int[] ans = new int[left.length + right.length];

        //先把两个集合中最小的值 合并进去一部分
        while (i < left.length && j < right.length){
            if (left[i] < right[j]){
                ans[k++] = left[i++];
            }else{
                ans[k++] = right[j++];
            }
        }
        //把左边剩余元素加进去
        while (i < left.length){
            ans[k++] = left[i++];
        }
        //把右边剩余元素加进去
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
        quickLoop(nums,0, nums.length - 1);
    }

    private void quickLoop(int[] nums,int low,int hgt){
        //两指针重叠 结束递归
        if (low >= hgt){
            return;
        }
        int left = low;
        int right = hgt;
        int key = nums[left];

        while (left < right){
            //右指针向前移动
            while (left < right && nums[right] >= key){
                right--;
            }
            //左指针向后移动
            while (left < right && nums[left] <= key){
                left++;
            }
            //交换中间值
            if (left < right){
                SortKt.swap(nums, left, right);
            }
        }
        //交换最小值
        SortKt.swap(nums, low, left);

        //分别对左右两区间进行排序
        quickLoop(nums, low, left - 1);
        quickLoop(nums, left + 1, hgt);
    }
}
