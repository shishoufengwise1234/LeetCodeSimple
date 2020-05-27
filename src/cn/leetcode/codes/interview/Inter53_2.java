package cn.leetcode.codes.interview;

import cn.leetcode.codes.PKt;

public class Inter53_2 {


     /**
       *
       * 刷题情况
       *
       * 题目地址：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
       *
       * 1 刷是否通过：没有通过
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

     public static void main(String[] args) {

//         int[] arr = new int[]{0,1,2,3,4,7,8};
         int[] arr = new int[]{0};

         int re = new Inter53_2().missingNumber(arr);

         PKt.out("re = "+re);

     }

    public int missingNumber(int[] nums) {

        int i = 0, j = nums.length - 1, m;

        while (i <= j) {
            m = (i + j) / 2;
            if (nums[m] == m) {
                i = m + 1;   //继续往后查找
            } else {
                j = m - 1; //在m的基础上 向前查找
            }
        }
        return i;





         // 双指针发 没有写对
//        int w = 0;
//        for (int q = 1; q <= nums.length - 1; q++) {
//            if (nums[q] - nums[w] != 1) {
//                return nums[q] - 1;
//            }
//            w++;
//        }
//        return 0;
    }



}
