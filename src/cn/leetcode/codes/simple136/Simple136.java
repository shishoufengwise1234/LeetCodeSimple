package cn.leetcode.codes.simple136;

import cn.leetcode.codes.PKt;

import java.util.HashMap;

public class Simple136 {

    /**
     * 刷题情况
     * <p>
     * 题目地址：https://leetcode-cn.com/problems/single-number/
     * <p>
     * 1 刷是否通过：
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
     *
     * 最优解析：
     */

    public static void main(String[] args) {

        int[] nums = {2,2,1};
//        int[] nums = {4,1,2,1,2};
        int number = new Simple136().singleNumber(nums);

        PKt.out(number);

    }

    /*
    136. 只出现一次的数字
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:

输入: [2,2,1]
输出: 1
示例 2:

输入: [4,1,2,1,2]
输出: 4
     */

    public int singleNumber(int[] nums) {
        if (nums == null){
            return 0;
        }
        //先放入HashMap
        HashMap<Integer,Integer> map = new HashMap<>();
        for (Integer i : nums) {
            Integer count = map.get(i);
            //放入map中
            count = count == null ? 1 : ++count;
            map.put(i,count);
        }
        //如果某个数据为 1 即为没有重复
        for (Integer i : map.keySet()) {
            if (map.get(i) == 1){
                return i;
            }
        }
        return -1;
    }

}
