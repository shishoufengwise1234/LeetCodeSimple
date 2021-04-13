package cn.leetcode.codes.simple80;

import cn.leetcode.codes.PKt;

import java.util.Arrays;

public class Simple80 {


    /**
     * 刷题情况
     * <p>
     * 题目地址：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
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
     * <p>
     * 最优解析：官方
     * <p>
     * <p>
     * 面试是否遇到过？
     * <p>
     * <p>
     * 企业：
     */

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};

        Simple80 simple80 = new Simple80();
        int re = simple80.removeDuplicates(nums);


        PKt.out(re);



        PKt.out(Arrays.toString(nums));

    }

    /*
    给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。

不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

 

说明：

为什么返回数值是整数，但输出的答案是数组呢？

请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

你可以想象内部操作如下:

// nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
int len = removeDuplicates(nums);

// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
 

示例 1：

输入：nums = [1,1,1,2,2,3]
输出：5, nums = [1,1,2,2,3]
解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 不需要考虑数组中超出新长度后面的元素。
示例 2：

输入：nums = [0,0,1,1,1,1,2,3,3]
输出：7, nums = [0,0,1,1,2,3,3]
解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。 不需要考虑数组中超出新长度后面的元素。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    //双指针
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int len = nums.length;
        if (len <= 2){
            return len;
        }
        int low = 2,first = 2;

        while (first < len){
            if (nums[low - 2] != nums[first]){
                nums[low] = nums[first];
                ++low;
            }
            ++first;
        }
        return low;
    }
}
