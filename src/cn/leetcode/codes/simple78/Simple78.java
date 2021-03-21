package cn.leetcode.codes.simple78;

import cn.leetcode.codes.PKt;

import java.util.ArrayList;
import java.util.List;

public class Simple78 {

    /**
     * 刷题情况
     * <p>
     * 题目地址：https://leetcode-cn.com/problems/subsets/
     * <p>
     * 1 刷是否通过：没有
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
     * 最优解析：
     */


    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        Simple78 simple78 = new Simple78();
        List<List<Integer>> lists = simple78.subsets(nums);

        PKt.out(lists);

    }


    /*
    给你一个整数数组nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。



示例 1：

输入：nums = [1,2,3]
输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
示例 2：

输入：nums = [0]
输出：[[],[0]]


提示：

1 <= nums.length <= 10
-10 <= nums[i] <= 10
nums 中的所有元素 互不相同

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subsets
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    //回溯算法
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length == 0) {
            return list;
        }
        dfs(nums, 0, list, new ArrayList<>());
        return list;
    }

    private void dfs(int[] nums, int begin, List<List<Integer>> ans, List<Integer> temp) {
        ans.add(new ArrayList<>(temp));
        for (int i = begin; i < nums.length; i++) {
            temp.add(nums[i]);
            dfs(nums, i + 1, ans, temp);
            //删除最后一个元素 防止 temp 集合只添加 不删除
            temp.remove(temp.size() - 1);
        }
    }
    //[[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
    //[[], [1], [1, 2], [1, 2, 3], [1, 2, 3, 3], [1, 2, 3, 3, 2], [1, 2, 3, 3, 2, 3], [1, 2, 3, 3, 2, 3, 3]]
}
