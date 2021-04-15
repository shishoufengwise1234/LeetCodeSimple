package cn.leetcode.codes.sort;

import java.util.Arrays;

public class DataSort5 implements DataSort{


    @Override
    public void bubbleSort(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            boolean isSwap = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] >= nums[j + 1]){
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
        if (nums == null || nums.length <= 1){
            return nums;
        }
        int half = nums.length >> 1;
        int[] left = Arrays.copyOfRange(nums, 0, half);
        int[] right = Arrays.copyOfRange(nums, half, nums.length);

        return margeToArray(margeSort(left), margeSort(right));
    }

    private int[] margeToArray(int[] left,int[] right){
        int[] ans = new int[left.length + right.length];

        int i = 0,j = 0,k = 0;
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
        quickLoop(nums,0,nums.length - 1);
    }

    private void quickLoop(int[] nums, int low, int hgt) {
        if (low >= hgt){
            return;
        }
        int left = low;
        int right = hgt;
        int key = nums[left];

        while (left < right){
            while (left < right && key <= nums[right]){
                right--;
            }
            while (left < right && nums[left] <= key){
                left++;
            }
            if (left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        int temp = nums[left];
        nums[left] = nums[low];
        nums[low] = temp;

        quickLoop(nums, low, left - 1);
        quickLoop(nums, left + 1, hgt);
    }
}
