package cn.leetcode.codes.sort;

import cn.leetcode.codes.PKt;

import java.util.Arrays;

public class DataSortMain {

    public static void main(String[] args) {

        int[] nums = {4,5,6,4,3,2,1,8,3,0,19};

        DataSort dataSort = new DataSort1();

        //冒泡排序
//        dataSort.bubbleSort(nums);

        //插入排序
//        dataSort.insertionSort(nums);

        //选择排序
        dataSort.selectSort(nums);

        //归并排序
//        nums = dataSort.margeSort(nums);

        PKt.out("nums = "+ Arrays.toString(nums));


    }
}
