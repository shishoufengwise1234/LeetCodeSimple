package cn.leetcode.codes.simple1051;

import cn.leetcode.codes.PKt;



public class Simple1051 {

     /**
       *
       * 刷题情况
       *
       * 题目地址：    https://leetcode-cn.com/problems/height-checker/
       *
       * 1 刷是否通过： 未完成
       *
       *
       * 2 刷是否完成：
       *
       *
       * 3 刷是否完成：
       *
       *
       * 4 刷是否完成：
       *
       *
       * 5 刷是否完成：
       *
       *
       *
       */
    /*




     */

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,4,5,7,1};

        int re = new Simple1051().heightChecker(arr);

        PKt.out("re = "+re);

    }

    public int heightChecker(int[] heights) {
        int[] arr = new int[101];
        for (int height : heights) {
            arr[height]++;
        }
        int count = 0;
        for (int i = 1, j = 0; i < arr.length; i++) {
            while (arr[i]-- > 0) {
                if (heights[j++] != i) count++;
            }
        }
        return count;
    }
}
