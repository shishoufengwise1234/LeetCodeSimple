package cn.leetcode.codes.simple167;

import cn.leetcode.codes.PKt;

import java.util.Arrays;

public class Simple167 {


    /**
     * 刷题情况
     * <p>
     * 题目地址：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
     * <p>
     * 1 刷是否通过：通过 自己算法  官方算法 双指针法
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
     * 最优解析：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/solution/shuang-zhi-zhen-on-shi-jian-fu-za-du-by-cyc2018/
     */


    public static void main(String[] args) {
        int[] ints = {2, 7, 11, 15};
//        int[] sumIns = new Simple167().twoSum(ints,26);
        int[] sumIns = new Simple167().twoSum(ints,9);

        PKt.out(Arrays.toString(sumIns));

    }

    /*
       167. 两数之和 II - 输入有序数组
给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。

函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

说明:

返回的下标值（index1 和 index2）不是从零开始的。
你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
示例:

输入: numbers = [2, 7, 11, 15], target = 9
输出: [1,2]
解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
     */

    //官方双指针法
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0){
            return null;
        }
        int low = 0,hgt = numbers.length - 1;
        while (low < hgt){
            int sum = numbers[low] + numbers[hgt];
            if (sum == target){
                return new int[]{low + 1,hgt + 1};
            }else if (sum > target){
                hgt--;
            }else{
                low++;
            }
        }
        return null;
    }

    //自己算法 暴力解法
    public int[] twoSum2(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0){
            return null;
        }
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j <= numbers.length - 1; j++) {
                if (numbers[i] + numbers[j] == target){
                    int[] sumIns = new int[2];

                    sumIns[0] = i + 1;
                    sumIns[1] = j + 1;

                    return sumIns;
                }
            }
        }
        return null;
    }

}
