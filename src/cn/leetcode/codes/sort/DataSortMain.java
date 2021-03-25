package cn.leetcode.codes.sort;

import cn.leetcode.codes.PKt;

import java.util.Arrays;

public class DataSortMain {

    public static void main(String[] args) {

        int[] nums = {4,5,6,4,3,2,1,8,3,0,19};

        DataSort dataSort;
//        dataSort = new DataSort1();
        //第二遍
//        dataSort = new DataSort2();
        //第三遍
        dataSort = new DataSort3();

        //冒泡排序
//        dataSort.bubbleSort(nums);

        //插入排序
//        dataSort.insertionSort(nums);

        //选择排序
//        dataSort.selectSort(nums);

        //归并排序
//        nums = dataSort.margeSort(nums);

        //快速排序
        dataSort.quickSort(nums);

        PKt.out("nums = "+ Arrays.toString(nums));


    }
}
