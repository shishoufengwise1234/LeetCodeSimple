package cn.leetcode.codes.simple53;

import cn.leetcode.codes.PKt;
import sun.print.SunMinMaxPage;

import java.util.HashMap;

public class Simple53 {

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int re = new Simple53().maxSubArray(nums);

        PKt.out("re = "+re);
    }

    /*
53. 最大子序和
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
进阶:

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     */

    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length <= 0){
            return 0;
        }
        //缓存最大值
        int ans = nums[0];
        //上一次求和数
        int sum = 0;
        for (int num : nums){
            //上一次sum 大于0 对本次求和有增值 则加上当前数据
            if (sum > 0){
                sum += num;
            }else{
                //上一次 sum<=0 对当前和没有增加 则从当前num 重新开始
                sum = num;
            }
            // 每次都求出最大数值
            ans = Math.max(ans,sum);
        }
        return ans;
    }
}
