package cn.leetcode.codes.simple349;

import cn.leetcode.codes.PKt;

import java.util.Arrays;
import java.util.HashSet;

public class Simple349 {


    /**
     * 刷题情况
     * <p>
     * 题目地址：https://leetcode-cn.com/problems/intersection-of-two-arrays/
     * <p>
     * 1 刷是否通过：没有
     *
     *没有想到使用 HashSet 去重
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
     * 最优解析：https://leetcode-cn.com/problems/intersection-of-two-arrays/solution/duo-chong-jie-fa-jie-jue-349-liang-ge-shu-zu-de-ji/
     */

    public static void main(String[] args) {

        int[] num1 = {1,2,2,1};
        int[] num2 = {2,2};

        int[] contains = new Simple349().intersection(num1,num2);
        PKt.out("contains = "+ Arrays.toString(contains));

    }

    /*
    349. 两个数组的交集
给定两个数组，编写一个函数来计算它们的交集。

示例 1：

输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]
示例 2：

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[9,4]


说明：

输出结果中的每个元素一定是唯一的。
我们可以不考虑输出结果的顺序。
     */

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null){
            return new int[]{};
        }
        HashSet<Integer> num1Set = new HashSet<>();
        HashSet<Integer> containSet = new HashSet<>();
        for (int num : nums1){
            num1Set.add(num);
        }
        for (int num2 : nums2){
            if (num1Set.contains(num2)){
                containSet.add(num2);
            }
        }
        int[] ints = new int[containSet.size()];
        int pos = 0;
        for (int n : containSet){
            ints[pos] = n;
            pos++;
        }
        return ints;
    }
}
