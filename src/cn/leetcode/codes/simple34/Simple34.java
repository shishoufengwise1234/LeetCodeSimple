package cn.leetcode.codes.simple34;

import cn.leetcode.codes.PKt;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt;

import java.util.Arrays;

public class Simple34 {


    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int[] re = new Simple34().searchRange(nums,8);

        PKt.out("re = "+ Arrays.toString(re));
    }

    /*
    34. 在排序数组中查找元素的第一个和最后一个位置
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length<= 0){
            return null;
        }
        int[] re = new int[2];
        int low = 0,hgt = nums.length - 1;
        while (low <= hgt){
            int mid = low + ((hgt - low) >> 1);
            if (nums[mid] < target){
                low = mid + 1;
            }else if (nums[mid] > target){
                hgt = mid - 1;
            }else{
                if (mid == 0 || nums[mid - 1] != target){
                    re[0] = mid;

                    low = mid + 1;
                }else if (mid == nums.length - 1 || nums[mid + 1] != target){
                    re[1] = mid;
                }

            }
        }
        return re;
    }
}
