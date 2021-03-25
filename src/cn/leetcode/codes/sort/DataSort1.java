package cn.leetcode.codes.sort;

import cn.leetcode.codes.PKt;

import javax.xml.stream.FactoryConfigurationError;
import java.beans.beancontext.BeanContext;
import java.util.Arrays;

//第一遍
public class DataSort1 implements DataSort {


    @Override
    public void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 是否提前退出循环标识 没有交换尽快退出循环
            boolean flag = false;
            //内层循环如果前面的交换过 就不进行循环了
            for (int j = 0; j < nums.length - i - 1; j++) {
                // 循环比较
                if (nums[j] > nums[j + 1]) {
                    SortKt.swap(nums, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    @Override
    public void insertionSort(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int val = nums[i];
            int j = i - 1;
            //在未排序的区间内查找位置
            for (; j >= 0; j--) {
                //移动数据
                if (nums[j] > val) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            //插入数据
            nums[j + 1] = val;
        }
    }

    @Override
    public void selectSort(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            //在未排序的部分中找出最小的数据
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            //达到插入条件
            if (min != i) {
                nums[min] = nums[i] + nums[min];
                nums[i] = nums[min] - nums[i];
                nums[min] = nums[min] - nums[i];
            }
        }

    }

    @Override
    public int[] margeSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int num = nums.length >> 1;
        int[] lefts = Arrays.copyOfRange(nums, 0, num);
        int[] rights = Arrays.copyOfRange(nums, num, nums.length);

        return margeTwoArray(margeSort(lefts), margeSort(rights));
    }

    private int[] margeTwoArray(int[] left, int[] right) {
        int l = 0, h = 0, r = 0;
        int[] result = new int[left.length + right.length];

        PKt.out("left = "+Arrays.toString(left) + " , right = "+Arrays.toString(right));

        //将两个集合中比较小的数据放入其中
        while (l < left.length && h < right.length) {
            if (left[l] < right[h]) {
                result[r] = left[l++];
            } else {
                result[r] = right[h++];
            }
            r++;
        }
        PKt.out("比较之后 ：" + Arrays.toString(result));

        //将左边数组中剩余数据放入 数组中
        while (l < left.length) {
            result[r++] = left[l++];
        }
        PKt.out("合并左边数组 ：" + Arrays.toString(result));

        //将右边数组中剩余数据放入 数组中
        while (h < right.length) {
            result[r++] = right[h++];
        }
        PKt.out("合并右边数组 ：" + Arrays.toString(result));
        PKt.out("\n");

        return result;
    }

    @Override
    public void quickSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        quickLoop(nums, 0, nums.length - 1);
//        sort2(nums, 0, nums.length - 1);
    }

    private void quickLoop(int[] nums, int low, int hgt) {
        if (low >= hgt) {
            return;
        }
        int left = low;
        int right = hgt;

        int key = nums[left];
        while (left < right) {
            //移动右指针向前走
            while (left < right && nums[right] >= key) {
                right--;
            }
            //移动左指针向后走
            while (left < right && nums[left] <= key) {
                left++;
            }

            PKt.out("left = " + left + " , right = " + right);

            //交换中间值
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                PKt.out("nums[left] = " + nums[left] + " , nums[right] = " + nums[right]);
            }
        }
        //对low 和 left 交换位置
        int temp = nums[low];
        nums[low] = nums[left];
        nums[left] = temp;

        //分别对左右两个区间进行排序
        quickLoop(nums, low, left - 1);
        quickLoop(nums, left + 1, hgt);
    }

    public void sort2(int arr[], int low, int high) {
        if (arr == null || arr.length <= 0) {
            return;
        }
        if (low >= high) {
            return;
        }

        int left = low;
        int right = high;

        int key = arr[left];

        while (left < right) {
            while (left < right && arr[right] >= key) {
                right--;
            }
            while (left < right && arr[left] <= key) {
                left++;
            }
            if (left < right) {
                swap(arr, left, right);
            }
        }
        swap(arr, low, left);
        System.out.println("Sorting: " + Arrays.toString(arr));
        sort2(arr, low, left - 1);
        sort2(arr, left + 1, high);
    }

    public void swap(int arr[], int low, int high) {
        int tmp = arr[low];
        arr[low] = arr[high];
        arr[high] = tmp;
    }
}
