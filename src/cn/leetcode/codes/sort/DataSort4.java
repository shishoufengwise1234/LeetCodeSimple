package cn.leetcode.codes.sort;

import java.util.Arrays;

public class DataSort4 implements DataSort{




    @Override
    public void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean isSwap = false;
            //内层循环 也要从0 开始枚举
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
        if (nums.length <= 1){
            return nums;
        }
        int half = nums.length >> 1;

        int[] left = Arrays.copyOfRange(nums,0 , half);
        int[] right = Arrays.copyOfRange(nums, half, nums.length);

        //分开排序 和 合并
        return margeToArray(margeSort(left), margeSort(right));
    }

    private int[] margeToArray(int[] left,int[] right){
        int[] ans = new int[left.length + right.length];

        int i = 0,j = 0,k = 0;

        //初次合并两个有序数组
        while (i < left.length && j < right.length){
            if (left[i] < right[j]){
                ans[k++] = left[i++];
            }else{
                ans[k++] = right[j++];
            }
        }
        //检查剩余数据
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
        if (nums.length == 0){
            return;
        }
        quickSortLoop(nums, 0, nums.length - 1);
    }

    private void quickSortLoop(int[] nums,int low,int hgt){
        if (low >= hgt){
            return;
        }
        int left = low;
        int right = hgt;
        int key = nums[left];

        while (left < right){
            //如果需要更改排序方式 只需要修改 内层循环 对 key 的判断即可
            while (left < right && nums[right] >= key){
                right--;
            }
            while (left < right && nums[left] <= key){
                left++;
            }
            if (left < right){
                int t = nums[left];
                nums[left] = nums[right];
                nums[right] = t;
            }
        }
        int t = nums[low];
        nums[low] = nums[left];
        nums[left] = t;

        //分别对两边区间进行排序
        quickSortLoop(nums, low, left - 1);
        quickSortLoop(nums, left + 1, hgt);
    }
}
