package cn.leetcode.codes.simple287;

import cn.leetcode.codes.PKt;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Simple287 {

    /**
     * 刷题情况
     * <p>
     * 题目地址：https://leetcode-cn.com/problems/find-the-duplicate-number/
     * <p>
     * 1 刷是否通过：通过
     * <p>
     * <p>
     * 2 刷是否完成：
     * <p>
     * <p>
     * 3 刷是否完成：
     * <p>
     * <p>
     * 4 刷是否完成：
     * <p>
     * <p>
     * 5 刷是否完成：
     * <p>
     * 最优解析：
     * <p>
     * <p>
     * 面试是否遇到过？
     * <p>
     * <p>
     * 企业：
     */


    public static void main(String[] args) {

//        int[] nums = {1,3,4,2,2};
        int[] nums = {3,1,3,4,2};
        Simple287 simple287 = new Simple287();

//        int re1 = simple287.findDuplicate1(nums);
//        int re3 = simple287.findDuplicate3(nums);
//        int re2 = simple287.findDuplicate2(nums);
        int re4 = simple287.findDuplicate4(nums);

//        PKt.out("re1 = "+re1 + ", re3 = "+re3 + " re2 = "+re2);
        PKt.out(re4);

    }


    /*
给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。

假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。

 

示例 1：

输入：nums = [1,3,4,2,2]
输出：2
示例 2：

输入：nums = [3,1,3,4,2]
输出：3
示例 3：

输入：nums = [1,1]
输出：1
示例 4：

输入：nums = [1,1,2]
输出：1
 

提示：

2 <= n <= 3 * 104
nums.length == n + 1
1 <= nums[i] <= n
nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
 

进阶：

如何证明 nums 中至少存在一个重复的数字?
你可以在不修改数组 nums 的情况下解决这个问题吗？
你可以只用常量级 O(1) 的额外空间解决这个问题吗？
你可以设计一个时间复杂度小于 O(n2) 的解决方案吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-the-duplicate-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /*
    1. 暴力解法 双重循环枚举判断重复
    2. 排序之后 使用双指针来判断
    3. 使用哈希表来判重
     */

    //暴力解法
    //超时
    public int findDuplicate1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    //排序之后使用双指针来判断
    public int findDuplicate2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        //排序
        Arrays.sort(nums);

        int i = 0,j = 1;
        while (i < nums.length && j < nums.length){
            if (nums[i++] == nums[j++]){
                return nums[i];
            }
        }
        return -1;
    }

    //排序之后使用双指针来判断
    public int findDuplicate3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    //二分查找法
    public int findDuplicate4(int[] nums) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        int l = 1,r = nums.length - 1,ans = -1;

        while (l <= r){
            int mid = (l + r) >> 1;
            int cot = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cot++;
                }
            }
            if (cot <= mid){
                l = mid + 1;
            }else{
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }




    }
