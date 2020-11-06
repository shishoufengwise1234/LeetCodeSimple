package cn.leetcode.codes.simple941;

public class Simple941_2 {


    public boolean validMountainArray(int[] A) {
        int len = A.length;
        int i = 0;
        //从左边开始搜索
        while (i + 1 < len && A[i] < A[i+1]){
            i++;
        }
        //如果最高点数据 是开始位置或结束位置 则不是山脉数组
        if (i == 0 || i == len - 1){
            return false;
        }
        //向右边开始搜索 数据依次减小
        while (i + 1 < len && A[i] > A[i + 1]){
            i++;
        }
        return i == len -1;
    }

}
