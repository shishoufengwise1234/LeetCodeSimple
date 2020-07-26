package cn.leetcode.codes.sort

interface DataSort {

    /**
     * 冒泡排序
     */
    fun bubbleSort(nums: IntArray)

    /**
     * 插入排序
     */
    fun insertionSort(nums: IntArray)

    /**
     * 选择排序
     */
    fun selectSort(nums: IntArray)

    /**
     * 归并排序
     */
    fun margeSort(nums : IntArray) : IntArray


}