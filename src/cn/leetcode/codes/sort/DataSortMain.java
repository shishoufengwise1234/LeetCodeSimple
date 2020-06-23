package cn.leetcode.codes.sort;

import cn.leetcode.codes.PKt;

import java.util.Arrays;

public class DataSortMain {

    public static void main(String[] args) {

        int[] nums = {4,5,6,4,3,2,1};

        DataSort dataSort = new DataSort1();

        //冒泡排序
//        dataSort.bubbleSort(nums);

        dataSort.insertionSort(nums);

        PKt.out("nums = "+ Arrays.toString(nums));


    }
}
