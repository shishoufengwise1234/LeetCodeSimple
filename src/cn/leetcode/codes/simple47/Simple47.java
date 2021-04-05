package cn.leetcode.codes.simple47;

import cn.leetcode.codes.PKt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Simple47 {

    public static void main(String[] args) {

        int[] nums = {1, 1, 2};
        List<List<Integer>> re = new Simple47().permuteUnique(nums);

        PKt.out("re = " + re);

    }

    /*

给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。



示例 1：

输入：nums = [1,1,2]
输出：
[[1,1,2],
 [1,2,1],
 [2,1,1]]
示例 2：

输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     */

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length == 0) {
            return lists;
        }
        //排序
        Arrays.sort(nums);

        int[] visited = new int[nums.length];
        permuteUniqueLoop(lists, nums, new ArrayList<Integer>(), visited);
        return lists;
    }

    private void permuteUniqueLoop(List<List<Integer>> lists, int[] nums, ArrayList<Integer> child, int[] visited) {
        if (child.size() == nums.length) {
            lists.add(new ArrayList<>(child));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //去重
            if (visited[i] == 1 || (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] != 1)) {
                continue;
            }
            child.add(nums[i]);
            visited[i] = 1;

            permuteUniqueLoop(lists, nums, child, visited);

            visited[i] = 0;
            child.remove(child.size() - 1);
        }
    }

}
