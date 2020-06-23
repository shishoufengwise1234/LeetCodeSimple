package cn.leetcode.codes.sort;

import javax.xml.stream.FactoryConfigurationError;
import java.beans.beancontext.BeanContext;

//第一遍
public class DataSort1 implements DataSort{


    @Override
    public void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 是否提前退出循环标识 没有交换尽快退出循环
            boolean flag = false;
            //内层循环如果前面的交换过 就不进行循环了
            for (int j = 0; j < nums.length - i - 1; j++) {
                // 循环比较
                if (nums[j] > nums[j+1]){
                    SortKt.swap(nums,j,j+1);
                    flag = true;
                }
            }
            if (!flag){
                break;
            }
        }
    }

    @Override
    public void insertionSort(int[] nums) {
        if (nums == null || nums.length <= 0){
            return;
        }
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int val = nums[i];
            int j = i - 1;
            //在未排序的区间内查找位置
            for (; j >= 0; j--) {
                //移动数据
                if (nums[j] > val){
                    nums[j+1] = nums[j];
                }else{
                    break;
                }
            }
            //插入数据
            nums[j+1] = val;
        }
    }

    @Override
    public void selectSort(int[] nums) {

    }
}
