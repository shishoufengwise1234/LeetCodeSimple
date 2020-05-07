package cn.leetcode.codes.interview;


import cn.leetcode.codes.PKt;

import java.util.HashMap;

public class Inter3 {

    /*

    找出数组中重复的数字。


在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

示例 1：

输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3
 

限制：

2 <= n <= 100000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


     */
    public static void main(String[] args) {

//        int[] nums = {2, 3, 1, 0, 2, 5, 3,2, 3, 1, 0, 2, 5, 3,2, 3, 1, 0, 2, 5, 3,2, 3, 1, 0, 2, 5, 3};
//        int[] nums = {3, 1,2, 3};
        int[] nums = {0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

//        int reTarget = new Inter3().findRepeatNumber(nums);
        int reTarget = new Inter3().findRepeatNumber2(nums);

        PKt.out("reTarget = "+reTarget);
    }


    // 该方式超时
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <= nums.length - 1; j++) {
                if (nums[i] == nums[j]){
                    return nums[i];
                }
            }
        }
        return 0;
    }


    // 使用 HashMap 或 HashSet
    // 已通过 √
    public int findRepeatNumber2(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                return nums[i];
            }else{
                map.put(nums[i],nums[i]);
            }
        }
        return 0;
    }


}
