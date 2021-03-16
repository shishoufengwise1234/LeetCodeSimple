package cn.leetcode.codes.simple169;

import cn.leetcode.codes.PKt;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Simple169 {


    /**
     * 刷题情况
     * <p>
     * 题目地址：https://leetcode-cn.com/problems/majority-element/
     * <p>
     * 1 刷是否通过：通过 使用 哈希表形式完成
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
     * 最优解析：官方
     */


    public static void main(String[] args) {

//        int[] nums = {3,2,3};
        int[] nums = {2, 2, 1, 1, 1, 2, 2};

        int majorNum = new Simple169().majorityElement(nums);
        int majorNum2 = new Simple169_2().majorityElement(nums);
        PKt.out("majorNum = " + majorNum);
        PKt.out("majorNum2 = " + majorNum2);

    }


    /*
    169. 多数元素
给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。


示例 1:

输入: [3,2,3]
输出: 3
示例 2:

输入: [2,2,1,1,1,2,2]
输出: 2
     */
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int n : nums) {
            if (countMap.containsKey(n)) {
                countMap.put(n, countMap.get(n) + 1);
            } else {
                countMap.put(n, 1);
            }
        }
        int major = nums.length / 2;
        Set<Map.Entry<Integer, Integer>> entrySet = countMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            if (entry.getValue() > major) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
