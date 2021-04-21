package cn.leetcode.codes.simple152;

import cn.leetcode.codes.PKt;

public class Simple152 {

    /**
     * 刷题情况
     *
     * 题目地址：https://leetcode-cn.com/problems/maximum-product-subarray/
     *
     * 1 刷是否通过：no
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
     * 最优解析：https://leetcode-cn.com/problems/maximum-product-subarray/solution/hua-jie-suan-fa-152-cheng-ji-zui-da-zi-xu-lie-by-g/
     *
     *
     * 面试是否遇到过？
     *
     *
     * 企业：
     *
     *
     *
     *
     */

    public static void main(String[] args) {

        int[] nums = {2,3,-2,4};

        int re = new Simple152().maxProduct(nums);

        PKt.out("re = "+re);

    }

    /*
    152. 乘积最大子数组
给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。



示例 1:

输入: [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
示例 2:

输入: [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
     */


    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE, iMax = 1, iMin = 1;

        for (int num : nums) {
            //出现小于0的数据 交换最大值跟最小值
            if (num < 0) {
                int temp = iMax;
                iMax = iMin;
                iMin = temp;
            }
            //求出最大值
            iMax = Math.max(iMax * num, num);
            iMin = Math.min(iMin * num, num);

            max = Math.max(max, iMax);
        }
        return max;
    }
}
