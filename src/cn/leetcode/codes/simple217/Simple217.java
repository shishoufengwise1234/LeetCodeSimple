package cn.leetcode.codes.simple217;

import cn.leetcode.codes.PKt;

import java.util.HashSet;

public class Simple217 {


    public static void main(String[] args) {
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        boolean isContains = new Simple217().containsDuplicate(nums);

        PKt.out(isContains);


    }

    /*
    217. 存在重复元素
给定一个整数数组，判断是否存在重复元素。

如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。

示例 1:

输入: [1,2,3,1]
输出: true
示例 2:

输入: [1,2,3,4]
输出: false
示例 3:

输入: [1,1,1,3,3,4,3,2,4,2]
输出: true
     */

    //借助 HashSet 实现检测是否重复
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0){
            return false;
        }
        HashSet<Integer> containSet = new HashSet<>();
        for (int n : nums){
            if (containSet.contains(n)){
                return true;
            }else{
                containSet.add(n);
            }
        }
        return false;
    }

}
