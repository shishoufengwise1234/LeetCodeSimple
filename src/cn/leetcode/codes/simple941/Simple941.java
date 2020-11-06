package cn.leetcode.codes.simple941;

import cn.leetcode.codes.PKt;

public class Simple941 {

    public static void main(String[] args) {

//        int[] nums = {2,1};
//        int[] nums = {3,5,5};
        int[] nums = {0,3,2,1};
        PKt.out(new Simple941().validMountainArray(nums));
        PKt.out(new Simple941_2().validMountainArray(nums));

    }

    /*
    941. 有效的山脉数组
给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。

让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：

A.length >= 3
在 0 < i < A.length - 1 条件下，存在 i 使得：
A[0] < A[1] < ... A[i-1] < A[i]
A[i] > A[i+1] > ... > A[A.length - 1]


示例 1：

输入：[2,1]
输出：false
示例 2：

输入：[3,5,5]
输出：false
示例 3：

输入：[0,3,2,1]
输出：true


提示：

0 <= A.length <= 10000
0 <= A[i] <= 10000
     */

    public boolean validMountainArray(int[] A) {
        int len = A.length;
        int i = 0;
        //递增扫描
        while (i + 1 < len && A[i] < A[i + 1]){
            i++;
        }
        //最高点不能是数组起点或最后一个数据
        if (i == 0 || i == len - 1){
            return false;
        }
        //递减扫描
        while (i + 1 < len && A[i] > A[i + 1]){
            i++;
        }
        //扫描结束 如果i值和 数组长度正常遍历一致 则为有效山脉数组
        return i == len - 1;
    }


}
