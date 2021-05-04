package cn.leetcode.codes.simple27;

import cn.leetcode.codes.PKt;

import java.util.Arrays;

public class Simple27 {

    public static void main(String[] args) {

        int[] ins = {0,5,2,8,2,2,2,2,2,56};

        PKt.out("length = "+ins.length);

        Simple27 simple27 = new Simple27();
//        int count = simple27.removeElement(ins,2);
//        PKt.out("count = "+count);

        Simple27_2 simple27_2 = new Simple27_2();
//        int count2 = simple27_2.removeElement(ins, 2);
        int count2 = simple27_2.removeElement2(ins, 2);
        PKt.out(Arrays.toString(ins));

        PKt.out("count2 = "+count2);



    }

    /*
    给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。

不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。

元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-element
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    示例 1:

给定 nums = [3,2,2,3], val = 3,

函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。

你不需要考虑数组中超出新长度后面的元素。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-element
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

示例 2:

给定 nums = [0,1,2,2,3,0,4,2], val = 2,

函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。

注意这五个元素可为任意顺序。

你不需要考虑数组中超出新长度后面的元素。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-element
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

     */



    // 0,5,2,8,2,2,2,2,2,56
    public int removeElement(int[] nums, int val) {
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                nums[pos] = nums[i];
                pos++;
            }
        }
//        PKt.out("removeElement() = "+Arrays.toString(nums));

        return pos;
    }

}
