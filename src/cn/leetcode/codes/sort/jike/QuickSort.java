package cn.leetcode.codes.sort.jike;

import cn.leetcode.codes.PKt;
import kotlin.random.RandomKt;

import java.util.Arrays;
import java.util.Random;

//快速排序
public class QuickSort {



    public static void main(String[] args) {

        int length = 40;
        int[] arr = new int[length];

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt();
        }
        PKt.out("待排序数据 ： "+Arrays.toString(arr));

        quickSort(arr, 0, length);

        PKt.out("排完序数据 ： "+Arrays.toString(arr));

    }


    static void quickSort(int[] arr, int l, int r) {
        // 递归的边界条件是区间中只有一个元素
        // x  : 记录从前向后扫描的位置
        // y  : 记录从后向前扫描的位置
        // z  : 基准值，选择待排序区间的第一个元素
        // while 循环中是 partition 过程
        // 每一轮，先从后向前扫，再从前向后扫
        if (l >= r) return;

        int x = l, y = r, z = arr[l];
        while (x < y) {
            while (x < y && arr[y] >= z){
                --y;
            }
            if (x < y) arr[x++] = arr[y];
            while (x < y && arr[x] <= z){
                ++x;
            }
            if (x < y) arr[y--] = arr[x];
        }

        // 将基准值 z 放入其正确位置数组的 x 位
        // 其实，此时 x==y，所以写成 arr[y] = z 也行
        // 再分别对左右区间，进行快速排序
        arr[x] = z;
        quickSort(arr, l, x - 1);
        quickSort(arr, x + 1, r);
    }

}
