package cn.leetcode.codes.simple90;

import cn.leetcode.codes.PKt;

import java.util.ArrayList;
import java.util.List;

public class Simple90 {

    /**
     * 刷题情况
     *
     * 题目地址：https://leetcode-cn.com/problems/subsets-ii/
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
     */


    public static void main(String[] args) {

        int[] nums = {1,2,2};
        Simple90 simple90 = new Simple90();
        List<List<Integer>> re = simple90.subsetsWithDup(nums);

        PKt.out(re);

    }

    /*
    给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。

 

示例 1：

输入：nums = [1,2,2]
输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
示例 2：

输入：nums = [0]
输出：[[],[0]]
 

提示：

1 <= nums.length <= 10
-10 <= nums[i] <= 10

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subsets-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return lists;
        }
        subsetsWith(lists,0,nums,new ArrayList<Integer>());
        return lists;
    }

    private void subsetsWith(List<List<Integer>> ans,int index, int[] nums, ArrayList<Integer> integers) {
        if (index == 0){
            ans.add(integers);
            return;
        }

    }


}
