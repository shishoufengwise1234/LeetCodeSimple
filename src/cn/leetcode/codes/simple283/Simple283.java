package cn.leetcode.codes.simple283;

import cn.leetcode.codes.PKt;

import java.util.Arrays;

public class Simple283 {


    public static void main(String[] args) {

        int[] nums = new int[]{0,1,0,3,12};
        PKt.out("移动前 : "+Arrays.toString(nums));

        new Simple283().moveZeroes(nums);

        PKt.out("移动后 : "+Arrays.toString(nums));


    }

    /*

283. 移动零
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:

必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。
     */


    public void moveZeroes(int[] nums) {
        if (nums == null)
            return;
        int q = 0,p = 0,n = nums.length;
        while (p < n){
            if (nums[p] != 0){
                int temp = nums[p];
                nums[p] = nums[q];
                nums[q++] = temp;
            }
            p++;
        }
    }

}
