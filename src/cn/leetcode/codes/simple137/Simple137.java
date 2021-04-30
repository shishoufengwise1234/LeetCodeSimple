package cn.leetcode.codes.simple137;

import cn.leetcode.codes.PKt;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Simple137 {

    /**
     * 刷题情况
     *
     * 题目地址：https://leetcode-cn.com/problems/single-number-ii/
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

//        int[] nums = {0,1,0,1,0,1,99};
//        int[] nums = {2,2,3,2};
        int[] nums = {2,2,3,3,3,2,1};
        int re = new Simple137().singleNumber2(nums);

        PKt.out(re);

    }


    /*

给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。



示例 1：

输入：nums = [2,2,3,2]
输出：3
示例 2：

输入：nums = [0,1,0,1,0,1,99]
输出：99


提示：

1 <= nums.length <= 3 * 104
-231 <= nums[i] <= 231 - 1
nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次


进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     */

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        //排序
        Arrays.sort(nums);

//        int ans = nums[0];
        int count = 0;

        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]){
                j = Math.max(j, j + 1);
                count = j;
                j = 0;
//                ans = nums[i];
            }else{
                j++;
            }
        }
        return nums[count];
    }

    //哈希表方式
    public int singleNumber2(int[] nums){
        if (nums == null || nums.length == 0){
            return -1;
        }
        HashMap<Integer,Integer> map = new HashMap<>();

        //利用哈希表去重
        for (int i : nums){
            if (map.containsKey(i)){
                map.put(i, map.getOrDefault(i, 0) + 1);
            }else {
                map.put(i, 1);
            }
        }
        //取出第一个元素
        Set<Map.Entry<Integer,Integer>> entrySet = map.entrySet();
        for (Map.Entry<Integer,Integer> entry : entrySet){
            if (entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return -1;
    }
}
