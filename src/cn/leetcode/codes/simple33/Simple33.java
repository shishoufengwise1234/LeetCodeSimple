package cn.leetcode.codes.simple33;

import cn.leetcode.codes.PKt;
import com.sun.deploy.ui.UIFactory;

import java.lang.annotation.Target;
import java.util.Arrays;

public class Simple33 {

    /**
     * 刷题情况
     *
     * 题目地址：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
     *
     * 1 刷是否通过：
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
     * 最优解析：
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

        int[] nums = {4,5,6,7,0,1,2};
        int target = 6;
        int re = new Simple33().search3(nums,target );

        PKt.out(re);

    }


    /*
33. 搜索旋转排序数组
整数数组 nums 按升序排列，数组中的值 互不相同 。

在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为
[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。

给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。



示例 1：

输入：nums = [4,5,6,7,0,1,2], target = 0
输出：4
示例 2：

输入：nums = [4,5,6,7,0,1,2], target = 3
输出：-1
示例 3：

输入：nums = [1], target = 0
输出：-1


提示：

1 <= nums.length <= 5000
-10^4 <= nums[i] <= 10^4
nums 中的每个值都 独一无二
题目数据保证 nums 在预先未知的某个下标上进行了旋转
-10^4 <= target <= 10^4


进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？
     */

    //分段使用二分查找法
    public int search3(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        int n = nums.length;

        //预处理数组为一时
        if (n == 1){
            return nums[0] == target ? 0 : -1;
        }
        int low = 0;
        int hgt = n - 1;

        while (low <= hgt){
            int mid = (hgt + low) / 2;
            if (nums[mid] == target){
                return mid;
            }
            //前半部分
            if (nums[0] <= nums[mid]){
                if (nums[0] <= target && target < nums[mid]){
                    hgt = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{
                //后半部分
                if (nums[mid] < target && target <= nums[n - 1]){
                  low = mid + 1;
                }else{
                    hgt = mid - 1;
                }
            }
        }
        return -1;
    }


    //排序之后 使用二分查找法 错误
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        //排序
        Arrays.sort(nums);

        int low = 0,hgt = nums.length - 1;
        while (low < hgt){
            int mid = low + (hgt - low) / 2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                low = mid + 1;
            }else{
                hgt = mid - 1;
            }
        }
        return -1;
    }

    //遍历方式 O(n)
    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                return i;
            }
        }
        return -1;
    }
}
