package cn.leetcode.codes.simple46;

import cn.leetcode.codes.PKt;

import java.util.ArrayList;
import java.util.List;

public class Simple46 {

    /**
     * 刷题情况
     *
     * 题目地址：https://leetcode-cn.com/problems/permutations/
     *
     * 1 刷是否通过： 没有
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
     * 最优解析：https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-by-powcai-2/
     *
     */

    public static void main(String[] args) {

        int[] nums = {1,2,3};

        List<List<Integer>> re = new Simple46().permute(nums);

        PKt.out("re = "+re);

    }

    /*
    给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    //回溯算法
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length == 0){
            return lists;
        }
        //去重 、剪枝
        int[] visited = new int[nums.length];
        permuteLoop(lists,nums,new ArrayList<>(),visited);
        return lists;
    }

    private void permuteLoop(List<List<Integer>> lists, int[] nums, List<Integer> child, int[] visited) {
        if (child.size() == nums.length){
            lists.add(new ArrayList<>(child));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //如果下一个标识还是 相同 就跳过 防止重复
            if (visited[i] == 1){
                continue;
            }
            //设置标识位
            visited[i] = 1;
            child.add(nums[i]);
            permuteLoop(lists, nums, child, visited);
            //重置标识位
            visited[i] = 0;
            child.remove(child.size() - 1);
        }
    }
}
