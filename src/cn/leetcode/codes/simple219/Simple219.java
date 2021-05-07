package cn.leetcode.codes.simple219;

import cn.leetcode.codes.PKt;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Simple219 {

    /**
     * 刷题情况
     *
     * 题目地址：https://leetcode-cn.com/problems/contains-duplicate-ii/
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

//        int[] nums = {1,2,3,1};
//        int k = 3;
//        int[] nums = {1,2,3,1,2,3};
//        int k = 2;
        int[] nums = {1,0,1,1};
        int k = 1;
        boolean re = new Simple219().containsNearbyDuplicate2(nums, k);

        PKt.out(re);

    }


    /*
给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。

 

示例 1:

输入: nums = [1,2,3,1], k = 3
输出: true
示例 2:

输入: nums = [1,0,1,1], k = 1
输出: true
示例 3:

输入: nums = [1,2,3,1,2,3], k = 2
输出: false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/contains-duplicate-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    //使用哈希表
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return false;
        }
        Map<Integer,Integer> map = new HashMap<>();
        boolean isContainsNearby = false;

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                int containsIndex = map.getOrDefault(nums[i],0);
                isContainsNearby = Math.abs(i - containsIndex) <= k;
                map.put(nums[i],containsIndex + 1);
            }else{
                map.put(nums[i],i);
            }
        }
        return isContainsNearby;
    }

    //使用哈希表
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            //哈希表中存在重复元素 直接返回
            if (set.contains(nums[i])){
                return true;
            }
            //不存在则加入哈希表中
            set.add(nums[i]);
            //如果哈希表中超过 k 个元素则移除前面的元素
            if (set.size() > k){
                set.remove(nums[i - k]);
            }
        }
        //默认不存在
        return false;
    }
}
